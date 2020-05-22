public static boolean isInteger(final String strInput) {
    boolean ret = true;
    try {
        Integer.parseInt(strInput);
    } catch (final NumberFormatException e) {
        ret = false;
    }
    return ret;
}