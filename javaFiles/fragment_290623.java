return Arrays.asList(new Object[][]{
            {3.0, 4.0, 7.0, -1.0},
            {4.0, 3.0, 7.0, 1.0},
            {8.0, 2.0, 10.0, 6.0},
            {-1.0, 4.0, 3.0, -5.0},
            {3256.0, 4.0, 3260.0, 3252.0}
    });

...

private double mExpectedSubResult;

/* CONSTRUCTOR THAT ASSIGNS THE FIELDS WITH THE TEST DATA */
public CalculatorModelPresenterTest(double numberOne, double numberTwo, double expectedResult, double expectedSubResult) {
    mNumberOne = numberOne;
    mNumberTwo = numberTwo;
    mExpectedResult = expectedResult;
    mExpectedSubResult = expectedSubResult;
}
...

/* THIS TEST WILL NOW PASS */
@Test
public void testSub() throws Exception {
    final double actualResult = mCalculatorModel.sub(mNumberOne, mNumberTwo);
    assertEquals(actualResult, mExpectedSubResult, 0);
}