public enum CharacterClass {
    LOWERCASE, SPECIAL, NUMBER, UPPERCASE;

    public static CharacterClass getClass(char c) {
        if (Character.isLowerCase(c)) {
            return LOWERCASE;
        }
        if (Character.isUpperCase(c)) {
            return UPPERCASE;
        }
        if (Character.isDigit(c)) {
            return NUMBER;
        }
        return SPECIAL;
    }
}