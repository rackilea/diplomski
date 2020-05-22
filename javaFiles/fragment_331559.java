static void setBackgroundImage(File file, Region region) throws MalformedURLException {
    Image image = new Image(file.toURI().toURL().toExternalForm());
    region.setBackground(new Background(new BackgroundImage(
            image,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT
    )));

}