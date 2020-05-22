public void ExceptionTest() throws Exception {
    try {
        Integer test = null;
        test.toString();
    } catch (NullPointerException e) {
        out.println("Catched inner NullPointerException");
            throw new Exception("My Exception", e);
    } finally {
        return;
    }
}

public void test() {
    try {
        ExceptionTest();
    } catch (Exception outer) {
        out.println("Catched: " + outer.getMessage());
    }
}