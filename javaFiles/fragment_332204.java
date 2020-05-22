public static <T> T parseString(String s) {
    return (T) new Date();
}

public static void test() {
    Date dt = parseString("date");
}