new Thread(new MyRunnable("some important string")).start();
...
private static class MyRunnable implements {
    private final String someImportantString;
    public MyRunnable(String someImportantString) {
        this.someImportantString = someImportantString;
    }
    // run by the thread
    public void run() {
       // use the someImportantString string here
       ...
    }
}