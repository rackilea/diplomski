class Foo {
    public static final boolean DEBUG;
    static {
        DEBUG = getDebugMode();
    }
    private static boolean getDebugMode() {
        //code to open a properties file, read the DEBUG property
        //and return the value
    }
}