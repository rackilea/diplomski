void doFoo() {
    final CountDownLatch latch = new CountDownLatch(1);
    new Thread(new Runnable() {

        @Override
        public void run() {
            //this is a http request
            appSignInfo = getAPKSignature(context, pkinfo.packageName);
            latch.countDown();
        }
    }).start();
    try {
        latch.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    if (appSignInfo == null) {
        return ret;
    }
}