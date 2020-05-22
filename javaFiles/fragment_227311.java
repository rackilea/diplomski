public static void main(String[] args) throws Exception {
    final String s1 = "1234567890";
    System.out.println(isParsableAsLong(s1));    // true
    System.out.println(isParsableAsDouble(s1));  // true

    final String s2 = "1234.56789";
    System.out.println(isParsableAsLong(s2));   // false
    System.out.println(isParsableAsDouble(s2)); // true
}

private static boolean isParsableAsLong(final String s) {
    try {
        Long.valueOf(s);
        return true;
    } catch (NumberFormatException numberFormatException) {
        return false;
    }
}

private static boolean isParsableAsDouble(final String s) {
    try {
        Double.valueOf(s);
        return true;
    } catch (NumberFormatException numberFormatException) {
        return false;
    }
}