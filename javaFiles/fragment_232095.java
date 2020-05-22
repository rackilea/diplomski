private void createSlideshow(Stage stage, ArrayList<BufferedImage> slideList, int durationInSecs) throws InterruptedException {

    stage.show();

    int numImages = slideList.size();

    BlockingQueue<Image> images = new ArrayBlockingQueue<>(3);

    Thread conversionThread = new Thread(() -> {
        for (BufferedImage bi : slideList) {
            try {
                images.put(SwingFXUtils.toFXImage(bi, null));
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }
    });
    conversionThread.setDaemon(true);
    conversionThread.start();

    Timeline slideshow = new Timeline();

    ImageView slide = new ImageView();

    for (int i = 0; i < slideList.size(); i++) {

        KeyFrame newImageFrame = new KeyFrame(Duration.seconds(durationInSeconds * 3 * i), e -> 
            slide.setImage(images.poll())); 

        KeyFrame startFadeIn = new KeyFrame(Duration.seconds(durationInSeconds * 3 * i), 
            new KeyValue(slide.opacityProperty(), 0));

        KeyFrame endFadeIn = new KeyFrame(Duration.seconds(durationsInSeconds * (3 * i + 1)), 
            new KeyValue(slide.opacityProperty(), 1));

        KeyFrame startFadeOut = new KeyFrame(Duration.seconds(durationInSeconds * (3 * i + 2)), 
            new KeyValue(slide.opacityProperty(), 1));

        slideshow.getKeyFrames().addAll(newImageFrame, startFadeIn, endFadeIn, startFadeOut);

    }
    slideshow.play();
}