public final class ExampleUtilities {
    // Example Utility method
    public static int foo(int i, int j) {
        int val;

        //Do stuff

        return val;
    }

    // Example Utility method overloaded
    public static float foo(float i, float j) {
        float val;

        //Do stuff

        return val;
    }

    // Example Utility method calling private method
    public static long bar(int p) {
        return hid(p) * hid(p);
    }

    // Example private method
    private static long hid(int i) {
        return i * 2 + 1;
    }
}