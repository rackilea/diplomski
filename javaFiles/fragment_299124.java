BlockingDeque<String> deque = new LinkedBlockingDeque<>();

new Thread(() -> {
    Scanner scanner = new Scanner(System.in);
    String input;
    do {
        System.out.println("Type a message");
        input = scanner.nextLine();
        deque.add(input);
    } while (!input.equals("hello"));
}).start();

String str;
do {
    str = deque.poll(10, TimeUnit.SECONDS);
} while (str != null && !str.equals("hello"));

System.out.println("REACHED HERE!");