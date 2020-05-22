public class FormulaServiceImplTest {

    FormulaService formulaService;

    @Test
    public void testValidateFormula() {

        formulaService = spy(new FormulaService());
        // Valid since methodThatCalculatAFormula returns 3`
        doReturn((double) 3).when(
                formulaService).methodThatCalculatAFormula(anyString(),
                        anyInt(), anyInt());
        assertTrue(formulaService.validateFormula("Valid"));

        // Not valid since methodThatCalculatAFormula returns 0
        doReturn((double)0).when(
                formulaService).methodThatCalculatAFormula(anyString(),
                        anyInt(), anyInt());
        assertFalse(formulaService.validateFormula("Not Valid"));
    }
}