class ClientCode {
    Example exampleInstance;

    void someMethod() {
        synchronized (exampleInstance) {
            //...
        }
    }
}