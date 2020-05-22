public class Example {
    ExecutorService executorService = Executors.newCachedThreadPool();
    public void init(){
        CountDownLatch latch = new CountDownLatch(1);
        Future<Boolean> submit = executorService.submit(new Thread3());
        executorService.execute(new Thread1(latch, submit));
        executorService.execute(new Thread2(latch));
    }

    public class Thread1 implements Runnable{
        private CountDownLatch latch;
        private Future<Boolean> thread3;
        public Thread1(CountDownLatch latch, Future<Boolean> thread3) {
            this.latch = latch;
            this.thread3 = thread3;
        }

        @Override
        public void run() {
            int i = 0;
            try {
                thread3.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            while (i < 50){
                LockSupport.parkNanos(1000);
                i++;
            }
            latch.countDown();
        }
    }

    public class Thread2 implements Runnable{
        private CountDownLatch latch;

        public Thread2(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                System.out.println("We can continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class Thread3 implements Callable<Boolean>{

        @Override
        public Boolean call() throws Exception {
            int i = 0;
            while (i < 50){
                LockSupport.parkNanos(1000);
                i++;
            }
            return true;
        }
    }

}