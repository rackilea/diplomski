BlockingDeque<String> deque = new LinkedBlockingDeque<>();

Thread thread = new Thread(() -> {
    Scanner scanner = new Scanner(System.in);
    String input;
    try {
        do {
            if (System.in.available() > 0) {
                input = scanner.nextLine();
                deque.add(input);
            } else
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    System.err.println("Thread stopped");
                    break;
                }
        } while (true);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
});
thread.start();

System.out.println("Type a message");
String str;
do {
    str = deque.poll(10, TimeUnit.SECONDS);
} while (str != null && !str.equals("hello"));

System.out.println("REACHED HERE!");

thread.interrupt();