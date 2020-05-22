public static boolean isInteger(final String s) {
    try {
        Integer.parseInt(s);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
}