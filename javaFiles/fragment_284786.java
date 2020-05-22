@Override
public void run() {
    CountDownLatch latchA = new CountDownLatch(Constants.THREAD_NUM);
    for(int i=0; i<Constants.THREAD_NUM; i++){
         RunnableFooClass rc = new RunnableFooClass(latchA);
         Thread t = new Thread(rc);
         t.start();
    }
    latchA.await(); // wait for termination of all subthreads
}