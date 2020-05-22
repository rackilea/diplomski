class MyThread extends Thread
{
    MyThread(final Runnable runnable, final Phaser phaser)
    {
        super(() -> {
            runnable.run();
            phaser.arrive();
        });
        phaser.register();
    }
}