public static void debugPrint(boolean isDebug, String format, Object... args) {
    if (!isDebug) {
        return; // don't print
    }
    System.out.format(format, args);
}