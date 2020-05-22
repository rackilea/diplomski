private static Thread thread;

public static void main(final String[] args) {

    ...

    startButton.addActionListener(e -> {
        thread = new Thread(Main::run);
        thread.start();
    });
    stopButton.addActionListener(e -> thread.interrupt());
}

private static void run() {
    try {
        while (true) {
            Thread.sleep(1000);
            System.out.println("do stuff");
        }
    } catch (final InterruptedException e) {
        return;
    }
}