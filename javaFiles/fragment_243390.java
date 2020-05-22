public static boolean digitsMatch(String guess, String answer) {

    int matchingIndex;
    while (guess.length() > 0) {

        // check if the first digit of the guess is in the answer
        matchingIndex = answer.indexOf(guess.charAt(0));

        // if not, there cannot possibly be four matches
        if (matchingIndex < 0) {
            return false;
        }

        // look at the rest of the guess
        guess = guess.substring(1);

        // and remove the no longer relevant character from the answer 
        answer = answer.substring(0, matchingIndex) +
            answer.substring(matchingIndex + 1);

    }

    return true;
}