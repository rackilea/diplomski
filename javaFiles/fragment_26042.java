public class Player1 implements Runnable{
    private final CountDownLatch countDownLatch;
    private final String s;
    public Player1(CountDownLatch c, String s){
        this.countDownLatch=c;
        this.s=s;
    }
    @Override
    public void run() {
        for(int i=0;i<200;i++){
            System.out.println(s+":"+i);
        }
        countDownLatch.countDown();
    }

}


public class Player2 implements Runnable{
    private final CountDownLatch countDownLatch;
    private final String s;
    public Player2(CountDownLatch c, String s){
        this.countDownLatch = c;
        this.s=s;
    }
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<200;i++){
            System.out.println(s+":"+i);
        }
    }
}