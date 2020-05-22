public class TestThread implements Runnable {

    InfoPaket info;
    int i = 0;

    public TestThread(InfoPaket info) {
        this.info = info;
    }

    public void run() {
        while (true) {
            i++;
            getInfo(i);
        }
    }

    void getInfo(int i2){
         info.isNew();
         info.getInfo(i2);
    }
}