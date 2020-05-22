private static void test(OutOfMemoryError o) {
    try {
        for (int n = 1; true; n += n) {
            int[] foo = new int[n];
        }
    } catch (OutOfMemoryError e) {
        System.out.println("Stack trace length=" + e.getStackTrace().length + 
                           ", object id=" + System.identityHashCode(e));
        if (e == o)
            System.out.println("Got the same OutOfMemoryError twice (abort)");
        else
            test(e);
    }
}

public static void main (String[] args) {
    test(null);
}