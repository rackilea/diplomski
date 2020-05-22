public int[] getPlayerGuess(String msg) {
    System.out.print(msg);
    String userGuess = Keyboard.readLine();
    if (userGuess.length() != 4) {
        return getPlayerGuess("\nYour code must be 4 digits - ");
    }
    if (userGuess.chars().distinct().count() != 4) {
        return getPlayerGuess("\nCode must have four unique digits - ");
    }
    return createArrayFromGuess(userGuess);
}