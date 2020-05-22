public class TestThread2 implements Runnable {

    InfoPaket info;
    int i = 0;

    public TestThread2(InfoPaket info) {
        this.info = info;
    }

    public void run() {
        while (i < 500000) {
            i++;
            setInfo(i);
        }
    }

    void setInfo(int i2) {

        info.setInfo("lelaoao", i2);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}