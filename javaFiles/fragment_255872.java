Future<Integer> future = executor.submit(new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 1e9; i++) {

        }
        return 123;
    }
});