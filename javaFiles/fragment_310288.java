private final Runnable asyncOperation = new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            timeoutable.longOperation();
        } catch (InterruptedException e) {
        }
    }

};

@Test
public void testMockitoConcurrentTimeoutSucceeds(){
    new Thread(asyncOperation).start();
    verify(timeoutable, timeout(2000)).longOperation();
}

@Test
public void testMockitoConcurrentTimeoutFails(){
    new Thread(asyncOperation).start();
    verify(timeoutable, timeout(100)).longOperation();
}