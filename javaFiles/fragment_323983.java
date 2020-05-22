public int test2() {
    try {
        throw new Exception();
    } catch (Exception e) {
        System.err.println("exception");
        e.printStackTrace(System.err);
        System.err.flush();
    } finally {

    }
    return 2;
}