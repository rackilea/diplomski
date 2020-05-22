@Test
    public void prepare() throws Exception {
        TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        subject.start();
        Observable<Void> obs = subject.prepare();
        obs.subscribe(testSubscriber);
        shadowOf(subject.getLooper()).getScheduler().advanceToNextPostedRunnable();
        testSubscriber.awaitTerminalEvent(15, TimeUnit.SECONDS);
        //assertion go here
        subject.quit();
    }