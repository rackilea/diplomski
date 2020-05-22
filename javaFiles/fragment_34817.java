boolean isProperName(String check) {
    char[] letters = check.toCharArray();
    String[] capLetters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    for (int i = 0; i <= capLetters.length; i++) {
        if (letters[0].equals(capLetters[i])) {
            return true;
        }
    }
    return false;
}