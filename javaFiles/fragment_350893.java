interface Example {

    static void doJob1(String arg) {
        verifyArg(arg);
        ...
    }

    static void doJob2(String arg) {
        verifyArg(arg);
        ...
    }

    private static void verifyArg(String arg) {
        ...
    }
}