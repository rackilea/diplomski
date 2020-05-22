root.setTop(marqueeLeft);
root.setBottom(marqueeRight);

Platform.runLater(new Runnable() {

    @Override
    public void run() {
        marqueeLeft.animate();
        marqueeRight.animate();
    }
});