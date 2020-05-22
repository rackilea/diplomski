public static int lastElement(String s) {
    // the last index is length - 1
    for (int i = s.length() - 1; i >= 0; i--) {
        // get the character at an index, rather than search for the index
        char ch = s.charAt(i);
        // if it's not a digit
        if (!Character.isDigit(ch)) 
            // return it as an upper case letter.
            return Character.toUpperCase(ch);
        // if it is a digit, you don't need to do anything 
        // as it will go onto the next index anyway.
    }
    return -1;
}