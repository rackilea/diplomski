Service<Void> cicle = new Service<Void>() {
    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            volatile boolean waiting = false;

            @Override
            protected Void call() throws Exception {
                Timer.start();
                while (Timer.update() / 1000 < time) {
                    System.out.println(Timer.update())
                }
                Platform.runLater(() -> close()); // wrapped in Platform#runLater
                return null;
            }
        };
    }
};