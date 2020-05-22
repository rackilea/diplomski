public void myMethod() throws ExceptionType1, ExceptionType2 {
    try {
        // Some code here which can throw exceptions
    } catch (ExceptionType1 e) {
        log(e);
        throw e;
    }
}