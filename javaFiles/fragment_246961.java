public void squeezeMe(char[] characters) {
    boolean copyThis = false;
    boolean wasLastASpace = false;

    int p = 0;
    for (int i = 0; i < characters.length; i++) {
        if (Character.isWhitespace(characters[i])) {
            copyThis = !wasLastASpace;
            wasLastASpace = true;
        } else {
            copyThis = true;
            wasLastASpace = false;
        }

        if (copyThis) {
            if (i != p) {
                characters[p] = characters[i];
            }
            p++;
        }
    }

    for (int i = p; i < characters.length; i++) {
        characters[i] = '\u0000';
    }
}