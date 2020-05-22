public static boolean isValidInput(int input, int[] acceptedInput) {
    for (int val : acceptedInput) { //Iterate through the accepted inputs
        if (input == val) {
            return true;
        }
    }
    return false;
}