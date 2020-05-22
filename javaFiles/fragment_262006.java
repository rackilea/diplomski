for (String userInput : separated) {

    try {
        int number = Integer.parseInt(userInput);
        proceedInt(number);
        continue; // we proceed to the next element prematurely since no double or string anyway
    } catch (NumberFormatException nfe) {
    }

    try {
        double number = Double.parseDouble(userInput);
        proceedDouble(number);
        continue; // proceed to the next element prematurely or you will also treat the input as a string and proceed the input twice: as a double and as a string
    } catch (NumberFormatException nfe) {
    }

    // if we landed here, we can say for sure that the input was neither integer nor double, so we treat it as a string
    proceedString(userInput);
}