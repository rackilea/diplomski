public class TestThread implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setParameter(String string) {
        // TODO Auto-generated method stub

    }
}