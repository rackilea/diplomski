public void SomeClass {

    private final CountDownLatch latch = new CountDownLatch(1);
    private int result;
    registerCallback(new MyCallback());

    public int callToExternalService(){
        //Do some stuff and make service call
        latch.await();
        return result;
    }

    private class MyCallback implements ServiceCallback {
        @Override
        public void onResult(final int res) {
            //do something
            result = res;
            latch.countdown();
        }
    }

    protected registerCallback(ServiceCallback callback) {
        registerCallbackWithService(callback);
    }
}