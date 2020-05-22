public class InfoPaket {

    String info;
    char infoDataSign;
    boolean newInfo = false;

    public synchronized boolean isNew() {
        if (!newInfo) {
            try {
                System.out.println("waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return newInfo;
    }

    public synchronized void getInfo(int i) {
        newInfo = false;
        System.out.println("he got it... " + info + "  " + i);
    }

    public synchronized void setInfo(String info, int i) {
        this.info = info;
        newInfo = true;
        System.out.println("here  " + i);
        notify();
    }

    public static void main(String[] args) {

        InfoPaket paket = new InfoPaket();
        TestThread testThread = new TestThread(paket);
        TestThread2 testThread2 = new TestThread2(paket);

        new Thread(testThread, "testThread").start();
        new Thread(testThread2, "testThread2").start();
    }
}