public static boolean isNumeric(final CharSequence cs) {
    if (isEmpty(cs)) {
        return false;
    }
    final int sz = cs.length();
    for (int i = 0; i < sz; i++) {
        if (Character.isDigit(cs.charAt(i)) == false) {
            return false;
        }
    }
    return true;
}