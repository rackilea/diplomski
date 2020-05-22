public class CalculatorTest {

    /**
     * Test method for {@link Calculator#doMath(java.lang.String, double, double)}.
     */
    @Test
    public void testDoMath() {

        Calculator calc = new Calculator();

        assertTrue(calc.doMath("1", 5, 7) == 12.0);
        assertTrue(calc.doMath("2", 5, 7) == -2.0);
        assertTrue(calc.doMath("3", 5, 7) == (5.0/7.0));
        assertTrue(calc.doMath("4", 5, 7) == (5.0*7.0));
    }

}