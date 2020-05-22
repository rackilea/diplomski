@Test
public void publishOnThreadTest() throws InterruptedException {
    Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
    CountDownLatch latch = new CountDownLatch(1);

    final Mono<String> mono = Mono.just("Publish on test: \n")
            .map(msg -> msg + "before: " + Thread.currentThread() )
            .publishOn(s)
            .map(msg -> msg + "\nafter: " + Thread.currentThread());

    new Thread(() -> mono.subscribe((String str) ->{
        System.out.println(str);
        latch.countDown();
    })).start();

    latch.await();
}