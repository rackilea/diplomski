public static void main(String[] args)
{
    final Phaser phaser = new Phaser(1);

    new MyThread(
        () -> {
            new MyThread(() -> System.out.println("B"), phaser).start();
            System.out.println("A");
            try
            {
                Thread.sleep(1000); // wait for 1s to prove main thread is really waiting
            }
            catch (InterruptedException e) {}
        },
        phaser
    ).start();

    phaser.arriveAndAwaitAdvance();

    System.out.println("Everything is done");
}