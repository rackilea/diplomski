@Test
public void checkPinsKnockedDownIsWithinRange() {
    int pins;
    int lowestPin = 10000;
    int highestPin = -10000;

    for (int i = 0; i < 100000; i++) {
        pins = tester.roll();
        if (pins > tester.NUMBER_OF_PINS) {
            fail("More than 10 pins were knocked down");
        }
        if (pins < 0) {
            fail("Incorrect value of pins");
        }

        if (highestPin < pins) {
            highestPin = pins;
        }

        if (lowestPin > pins) {
            lowestPin = pins;
        }
    }

    if (lowestPin == highestPin) {
        fail("The highest pin count is the same as the lowest pin count. Check the method is returning a random number, and re-run the test.");
    }

    if (lowestPin != 0) {
        fail("The lowest pin is " + lowestPin + " and it should be zero.");
    }

    if (highestPin != tester.NUMBER_OF_PINS) {
        fail("The highest pin is " + highestPin + " and it should be " + tester.NUMBER_OF_PINS + ".");
    }

}