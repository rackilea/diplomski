static boolean Marathon(int a) {
    boolean rv = false;
    try {
        if (a < 0)
            throw new NegativeException();
        else if (a == 0)
            throw new ZeroException();
        else if (a >= 42)
            rv = true;
    } catch (ZeroException e) {
        System.out.println("Use natural number");
    } finally {
        System.out.println("One last thing");
    }
    System.out.println("All done.");
    return rv;
}