public class Stone implements Runnable {
    static int id = 1;
    static StringBuffer buffer = new StringBuffer();

    public void run() {
        try {
            id = 1 - id;
            if (id == 0) {
                pick();
            } else {
                release();
            }

        } catch (Exception e) {
        }
    }

    private static synchronized void pick() throws Exception {
        buffer.append("P ");
        buffer.append("Q ");
    }

    private synchronized void release() throws Exception {
        buffer.append("R ");
        buffer.append("S ");
    }

    public static void main(String[] args) {
        int count = 1000000;
        Map<String, Integer> results = new HashMap<String, Integer>();
        System.out.println("Running " + count + " times...");
        for (int i = 0; i< count; i++) {
            buffer = new StringBuffer();
            Stone stone = new Stone();
            Thread t1 = new Thread(stone);
            Thread t2 = new Thread(stone);
            t1.start();
            t2.start();
            while (t1.isAlive() || t2.isAlive()) {
                // wait
            }
            String result = buffer.toString();
            Integer x = results.get(result);
            if (x == null) x = 0;
            results.put(result, x + 1);
            if (i > 0 && i % 50000 == 0) System.out.println(i + "... " + results.keySet());
        }
        System.out.println("done, results were:");
        for (String key : results.keySet()) {
            System.out.println(" " + key + ": " + results.get(key));
        }
    }
}