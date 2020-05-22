public class LostThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int value = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(value);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}