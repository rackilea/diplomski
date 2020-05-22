public static String format(String message, Object expected, Object actual) {
    String formatted = "";
    if (message != null && message.length() > 0) {
        formatted = message + " ";
    }
    return formatted + "expected:<" + expected + "> but was:<" + actual + ">";
}