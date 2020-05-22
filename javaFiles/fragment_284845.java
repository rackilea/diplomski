for (i = 0; i < secretCode.length(); i++) {
    if (i < usersGuess.length()) {
        char digit = usersGuess.charAt(i);
        if (digit == secretCode.charAt(i)) {
            System.out.println(digit);
            correctPosition++;
        }
    }
}