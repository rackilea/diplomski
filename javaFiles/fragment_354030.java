String fileName, maxLengthInput, minLengthInput;
int maxLength, minLength;

List<String> errors = new ArrayList<>();

try {
    maxLength = Integer.parseInt(maxlengthInput);
} catch (NumberFormatException nfe) {
    errors.add("Invalid input for maximum length, input is not a number");
}

try {
    minLength = Integer.parseInt(minlengthInput);
} catch (NumberFormatException nfe) {
    errors.add("Invalid input for minimum length, input is not a number");
}

// show all error strings to the user