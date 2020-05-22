public void test() {

    MyThreadFactory threadFactory = new MyThreadFactory();
    YourClass yourClass = new YourClass(threadFactory);

    yourClass. // invoke method under test

    assertThat(threadFactory.numberOfInvocations()).isEqualTo(1);

}