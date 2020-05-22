public Callable<String> foo(final Object o) {
    return new Callable<String>() {
        public String call() throws InterruptedException {
            String s = o.toString();
            Thread.sleep(1000000);
            return s;
        }
    };
}