public class CallThread implements Runnable {
    private final CountDownLatch completionLatch = new CountDownLatch(1);

    public void run(){
        callService();

        //Wait without timeout, bad idea
        try {
            completionLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void callService() {
        //Service is the object that calls the service
        Service service = getService();
        //Request object is populated
        ResponseObserver response = new MyResponseObserver(completionLatch);
        Request request = supplyRequest();
        service.getDetails(request, response);
    }

    class MyResponseObserver {
        private CountDownLatch completionLatch;

        MyResponseObserver(CountDownLatch latch) {
            this.completionLatch = latch;
        }

        public void onException(){
            /* Retry on exception */
            callService();
        }
        public void onCompletion(){
            completionLatch.countDown();
            //process the result
        }
        public void onProcessing(){
            //This could be called multiple time
        }
    };
}