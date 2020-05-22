/**
     * A better implementation of isLetter -- the default GWT version doesn't 
     * support non-English characters.
     *
     * @param c the character to check
     * @return whether the character represents and alphabetic symbol.
     */
    public static boolean isLetter(char c) {
        int val = (int) c;

        return inRange(val, 65, 90) || inRange(val, 97, 122) || inRange(val, 192, 687) || inRange(val, 900, 1159) ||
        inRange(val, 1162, 1315) || inRange(val, 1329, 1366) || inRange(val, 1377, 1415) || inRange(val, 1425, 1610);
    }

    /**
     * Checks if an int value is in a range.
     * @param value value to check
     * @param min min value
     * @param max max value
     * @return whether value is in the range, inclusively.
     */
    public static boolean inRange(int value, int min, int max) {
        return (value <= max) & (value >= min);
    }