@Test
public void name1() throws Exception {

        Observable<Integer> value = Observable.just(1_000, 2_000, 3_000, 4_000, 5_000)
                .flatMap(i -> Observable.fromCallable(() -> doWork(i)).subscribeOn(Schedulers.io())
                ).doOnNext(integer -> System.out.println("value"));

        value.test().awaitTerminalEvent();
}

private int doWork(int sleepMilli) {
        try {
            Thread.sleep(sleepMilli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return -1;
}