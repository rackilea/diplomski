public static class ConsoleInputReadTask {
    private final AtomicBoolean stop = new AtomicBoolean();

    public void stop() {
        stop.set(true);
    }

    public String requestInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ConsoleInputReadTask run() called.");
        String input;
        do {
            System.out.println("Please type something: ");
            try {
                // wait until we have data to complete a readLine()
                while (!br.ready() && !stop.get()) {
                    Thread.sleep(200);
                }
                input = br.readLine();
            } catch (InterruptedException e) {
                System.out.println("ConsoleInputReadTask() cancelled");
                return null;
            }
        } while ("".equals(input));
        System.out.println("Thank You for providing input!");
        return input;
    }
}

public static void main(String[] args) {
    final Thread scannerThread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                String string = new ConsoleInputReadTask().requestInput();
                System.out.println("Input: " + string);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    });
    scannerThread.start();

    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            scannerThread.interrupt();
        }
    }).start();
 }