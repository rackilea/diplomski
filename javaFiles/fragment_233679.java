public static int[] getCodePoints(String text) {
    int[] ret = new int[text.codePointCount(0, text.length())];
    int charIndex = 0;
    for (int i = 0; i < ret.length; i++) {
        ret[i] = text.codePointAt(charIndex);
        charIndex += Character.charCount(ret[i]);
    }
    return ret;
}