public static boolean isValidInput(String input, String[] acceptedInput) {
    for (String val : acceptedInput) { //Iterate through the accepted inputs
        if (val.equals(input)) {
            return true;
        }
    }
    return false;
}