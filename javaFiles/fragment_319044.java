Platform.runLater(new Runnable() {
    @Override
    public void run() {
        webEngine.executeScript("foo()")
    }
});