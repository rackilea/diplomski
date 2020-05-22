readData.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {

        Thread readValThread = new Thread(createReadValTask());
        readValThread.setDaemon(true);
        readValThread.start();
    }
});