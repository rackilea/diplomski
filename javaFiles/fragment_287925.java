private static int compareStrings(final String str1, final String str2) {
    if (str1 == null) {
        if (str2 == null)) {
            return COMPARE_ABSENT;
        } else {
            return COMPARE_DIFFERS;
        }
    } else {
        if (str2 == null)) {
            return COMPARE_DIFFERS;
        } else {
            return str1.equals(str2) ? COMPARE_EQUALS : COMPARE_DIFFERS;
        }
    }
}