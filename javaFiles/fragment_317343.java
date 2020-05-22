public static boolean isEntirelyInBasicMultilingualPlane(String text) {
    for (int i = 0; i < text.length(); i++) {
        if (Character.isSurrogate(text.charAt(i))) {
            return false;
        }
    }
    return true;
}