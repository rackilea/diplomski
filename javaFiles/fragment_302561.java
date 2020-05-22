Timeline timeline = new Timeline(
    new KeyFrame(Duration.seconds(2), e -> myMethod()),    
    new KeyFrame(Duration.seconds(3), e -> myMethod()),
    new KeyFrame(Duration.seconds(5), e -> myMethod())
);

// If you want to repeat indefinitely:
timeline.setCycleCount(Animation.INDEFINITE);

timeline.play();