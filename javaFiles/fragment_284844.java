for (i = 0; i < secretCode.length(); i++) {
    for (int x = 0; x < usersGuess.length(); x++) {
        char digit = usersGuess.charAt(x);
        if (digit == secretCode.charAt(i)) {
            System.out.println(digit);
            correctPosition++;
        }
    }
}