@Test
public void testGo() {
    /* Given */
    TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider();

    Api api = spy(new Api() {
        @Override
        public Observable<String> webCall() {
            return Observable.just("First");
        }

        @Override
        public Observable<String> webCall2() {
            return Observable.just("second");
        }

        @Override
        public void webCall3() {
        }
    });

    Test test = new Test(api, testSchedulerProvider);

    /* When */
    test.go();
    testSchedulerProvider.io().triggerActions();
    testSchedulerProvider.mainThread().triggerActions();

    /* Then */
    verify(api).webCall();
    verify(api).webCall2();
    verify(api).webCall3("First", "second");
}