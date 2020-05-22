public class Deadlock1 {
    static class Client {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";

        void doS1() {
            synchronized (resource1) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                doS2();
            }
        }

        void doS2() {
            synchronized (resource2) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
                doS1();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        new Thread(client::doS1).start();
        new Thread(client::doS2).start();
    }
}