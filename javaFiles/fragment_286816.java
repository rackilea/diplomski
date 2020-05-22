public class Deadlock2 {
    static class Client {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
    }

    public static void main(String[] args) {
        Client client = new Client();

        new Thread(
                () ->
                {
                    synchronized (client.resource1) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                        }

                    }
                    synchronized (client.resource2) {}
                }).start();

        new Thread(
                () ->
                {
                    synchronized (client.resource2) {
                        try {
                            System.out.println("3");
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                        }
                    }
                    synchronized (client.resource1) {}
                }).start();
    }
}