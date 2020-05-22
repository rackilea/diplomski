Observable.fromCallable(new Callable<File>() {
    @Override
    public File call() throws Exception {
        return downloadFileFromNetwork();
    }
}