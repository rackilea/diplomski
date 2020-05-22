public class BuzzerSignaler {
    private long timeout;
    private volatile boolean shouldStop = false;

    public static void main(String... args) {
        BuzzerSignaler signaler = new BuzzerSignaler();
        try {
            signaler.buzzStart(100);
            Thread.sleep(1000);
            signaler.buzzStop();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public void buzzStart() throws Exception {
        this.timeout = 0;
        action('1');
    }

    public void buzzStart(long timeout) throws Exception {
        this.timeout = timeout;
        new Thread(() -> {
            while (shouldStop == false) {
                try {
                    Thread.currentThread().sleep(this.timeout);
                    action('1');
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }).start();
    }

    public void buzzStop() throws Exception {
        //stop delay
        shouldStop = true;
        action('0');
    }

    private void action(char offOn) throws Exception {
        System.out.println("I'm working..." + offOn);
    }
}