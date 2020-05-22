public class WrapperRunnable implements Runnable {

    Runnable runnable;

    public WrapperRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        while (true) {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}