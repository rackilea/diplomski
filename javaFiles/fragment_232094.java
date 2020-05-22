private void createSlideshow(Stage stage, ArrayList<BufferedImage> slideList, int durationInSecs) throws InterruptedException {

    stage.show();
    Timeline slideshow = new Timeline();

    ImageView slide = new ImageView();

    for (int i = 0; i < slideList.size(); i++) {
        BufferedImage bi = slideList.get(i);
        KeyFrame newImageFrame = new KeyFrame(Duration.seconds(durationInSeconds * 3 * i), e -> 
            slide.setImage(SwingFXUtils.toFXImage(bi, null)));

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