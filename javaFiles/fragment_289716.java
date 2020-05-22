double i;
try {
    i = Double.parseDouble(userInput);
} catch (NumberFormatException e) {
    addValidationError("Entered number is not valid: " + userInput);
}