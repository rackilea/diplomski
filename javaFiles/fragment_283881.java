public static void exceptionTest() {
    makeNullPointer(); //The compiler allows me not to check this
    try {
        throwAnException(); //I'm forced to handle the exception, but I don't want to
    } catch (Exception e) { /* do nothing */ }
}