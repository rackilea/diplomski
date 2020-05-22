// Sample input used.
    String input = "23 54 343 75.6 something 22.34 34 whatever 12";
    // Each number will be temporarily stored in this variable.
    Double numberInput;
    // Counter used to keep track of the valid number inputs.
    int counter = 0;
    // The index directly after the number ends.
    int endIndex = 0;
    // Now we simply loop through the string.
    for (int beginIndex = 0; beginIndex < input.length(); beginIndex = endIndex + 1) {
        // Get the index of the next space character.
        endIndex = input.indexOf(" ", beginIndex);
        // If there are no more spaces, set the endIndex to the end of the string.
        if (endIndex == -1) {
            endIndex = input.length();
        }
        // Take out only the current number from the input.
        String numberString = input.substring(beginIndex, endIndex);
        try {
            // If the number can be converted to a Double, increase the counter.
            numberInput = Double.parseDouble(numberString);
            counter++;
        } catch (java.lang.NumberFormatException nfe) {
            // Some error handling.
            System.err.println("Invallid input: " + numberString);
        }
    }
    System.out.println("Total valid numbers entered: " + counter);