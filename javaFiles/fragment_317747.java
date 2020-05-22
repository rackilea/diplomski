private void NPWake() {
    Thread t = new Thread(() -> {
        while (wakeful) {
            try {
                Platform.runLater(() -> {
                    displaySldr.setValue(Math.floor(Math.random() * 100));
                });

                Thread.sleep(300);
            }
            catch (Exception e) {}
        }
    });
    t.start();
}