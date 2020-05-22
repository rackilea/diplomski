public static void hello(String name) throws IOException {
    Observable<String> obs2 = Observable.fromCallable(() -> {
                if ("CCCCC".equals(name)) {
                    // pause for 150ms before emitting "CCCCC"
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return name;
            }
    ).timeout(100, MILLISECONDS) // timeout if there is a pause in emission of more than 100ms
            .subscribeOn(Schedulers.io());

    obs2.subscribe(s -> System.out.println(s + " " + new Date() + " " + Thread.currentThread().getName()),
            throwable -> System.err.println(throwable.getClass().getSimpleName() + " " + new Date() + " " + Thread.currentThread().getName()));
}