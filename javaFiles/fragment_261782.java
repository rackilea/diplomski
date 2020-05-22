Callable<Bar> getFoo = new Callable<Bar>() {
    @Override
    public Bar call() {
        return lotuNotes.getFoo();
    }
};
Future<Bar> future = executor.submit(getFoo);
return future.get();