class MyTask implements Callable<Void> {
    @Override
    public Void call() throws Exception {
        // do something

        return null;
    }
}

...

private static void callingMethod() {
    createMenu("menu name", new MyTask(), new MyTask(), new MyTask());
}