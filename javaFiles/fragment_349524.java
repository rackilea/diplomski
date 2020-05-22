void someMethod() {
    String method = "none";
    try {
        method = "doSomething";
        doSomething();

        method = "doSomethingElse";
        doSomethingElse();
    } catch (IllegalInputException e) {
        handleError(method, e); // don't ignore the exception.
    }