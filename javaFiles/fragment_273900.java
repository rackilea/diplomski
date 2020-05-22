private void loadGraphFromServer() {
    final Phaser phaser = new Phaser(1); // "1" registers the calling thread
    for (final Item item : getDataListFromServer()) {
        phaser.register();
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    getMoreDataFromServer(item.getSomeId());
                    // more nested loops/tasks/calls here...
                }
                finally {
                    phaser.arrive();
                }
            }
        });
    }
    phaser.arriveAndAwaitAdvance(); // blocks until all tasks are complete
}