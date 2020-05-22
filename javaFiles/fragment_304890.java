private static boolean check(String dirtyText) {
    String allowedCharacters = "abcdefhijk$<>/lmnoqrgstuvwxyz";
    for (int i=0; i < dirtyText.length(); i++) {
        if (!allowedCharacters.contains(dirtyText.substring(i, i+1))) {
            return false;
        }
    }
    return true;
}