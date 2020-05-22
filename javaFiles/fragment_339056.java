private boolean isValid(char c) {
    for (int i = 0; i < letters.length; i++) {
        if (letters[i] == c) {
            return false;
        }
    } 
    return true;
}