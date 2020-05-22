Task<Image> imageTask = new Task<Image>() {
    @Override
    public Image call() {
        WritableImage image = new WritableImage(...);
        // draw on image....
        return image ;
    }
});

imageTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent event) {
        myImageProperty.set(imageTask.getValue());
    }
});

new Thread(imageTask).start();