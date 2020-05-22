void somefunction() {
    try {
        aMock.doSomething();
        bMock.another();
    } catch(Exception ex) {
        cMock.handleException(ex);
    }
}