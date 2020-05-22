@PrepareForTest(Program.class)
public class Test {
    @Test
    public void testMethod() {
        ArbitraryType passedLocalInstance = new ArbitraryType();
        PowerMock.expectNew(ArbitraryType.class).andReturn(passedLocalInstance );

        //remainder of the test method

        assertEquals(14.2, passedLocalInstance .getValue());
    }
}