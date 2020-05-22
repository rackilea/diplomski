public <T> T myMethod() {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
        try {
            T value = executor.invokeAny(Collections.singleton(new Callable<T>() {
                @Override
                public T call() throws Exception {
                    //your actual method code here
                    return null;
                }
            }), 3, TimeUnit.SECONDS);
            System.out.println("All went fine");
            return value;
        } catch (TimeoutException e) {
            System.out.println("Exceeded time limit, interrupted");
        } catch (Exception e) {
            System.out.println("Some error happened, handle it properly");
        }
        return null; /*some default value*/
    } finally {
        executor.shutdownNow();
    }
}