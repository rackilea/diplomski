static Completable createRequestCompletable(String name) {
    final CountDownLatch latch = new CountDownLatch(1);
    return Completable.create(e -> {
        executeRequest(name, () -> {
            e.onComplete();
            latch.countDown();
        });
        latch.await();
    })
    .doOnSubscribe(disposable -> System.out.println("Subscribed to " + name));
}