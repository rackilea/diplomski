private int imageIndex = 0 ;
private final int frameTime = ... ; // milliseconds

// ...

ImageView imageView = new ImageView();
List<Image> images = new ArrayList<>();
// populate images...

Timeline timeline = new Timeline(new KeyEvent(Duration.millis(frameTime),
    e -> imageView.setImage(images.get(imageIndex++))));

timeline.setCycleCount(images.size());
timeline.play();