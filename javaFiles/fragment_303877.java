taskThread = new Thread( () -> {
    while (! Thread.currentThread().isInterrupted()) {
        Platform.runLater( snake::updatePosition );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            break ;
        }
    }
});