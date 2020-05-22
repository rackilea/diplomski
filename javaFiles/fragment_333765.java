public static void f() throws Exception {
    try {
        statement1();
    } catch (TheException e) {
        doSomething1();
        // return or throw
    }
    try {
        statement2();
    } catch (TheException e) {
        doSomething2();
        // return or throw
    }
    try {
        statement3();
    } catch (TheException e) {
        doSomething3();
        // return or throw
    }
}