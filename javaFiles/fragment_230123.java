@Test
public void testPrimeNumberChecker() {
    try {
        assertEquals(isPrime, PrimeNumberChecker.validate(inputNumber));
        parameterResults.get(inputNumber).addSuccess();
    } catch (AssertionError e) {
        parameterResults.get(inputNumber).addFail();
        throw e;
    }
}