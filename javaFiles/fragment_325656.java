public void doSomething() {
    try {
        //do something
    } catch (Exception e) {
        handleError(e);
    }
}

public void doSomethingElse() {
    try {
        //do something else
    } catch (Exception e) {
        handleError(e);
    }
}

private void handleError(Exception e) {
    //extensive error handling
}