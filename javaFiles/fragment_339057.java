private boolean isValid(char c) {
    for (char letter : letters) { // <-- for each letter in letters.
        if (letter == c) {        // <-- if the letter is equal to the argument.
            return false;
        }
    } 
    return true;
}