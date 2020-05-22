public class Test {
    public static void main(String[] args) {
        final int SIZE = 100000;
        final Random rand = new Random();
        final List<Integer> list = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        Runnable remove = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    int i = rand.nextInt(SIZE);
                    list.remove(i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        break;
                    }
                    list.add(i);
                }
            }
        };
        Thread t = new Thread(remove);
        t.start();
        for (int i = 0; i < 100; i++) {
            try {
                for (Integer j: list) {
                    ///whatever
                }
            } catch (ConcurrentModificationException e) {
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        t.interrupt();
    }
}