public static CountDownLatch latch = new CountDownLatch(1);
private static class Job implements Runnable{
private int balance;

public void run(){
    try {
    latch.await();
    } catch (InterruptedException e) {}
    for (int i = 0; i < 50000; i++) {
        //existing code
    }
}
public void increment(){
    int i = balance;
    //make it work harder so there's more opportunity for an actual interleave
    balance = new BigInteger(Integer.toString(i)).add(BigInteger.ONE).intValue();
}
}

public static void main(String[] args) {
    //existing code
    alpha.start();
    beta.start();
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {}
    latch.countDown();

}