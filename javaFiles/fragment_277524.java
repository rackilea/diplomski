pause.getKeyFrames().add(new KeyFrame(Duration.ZERO,
    new KeyValue(obBorder.backgroundProperty(),
        new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)))));

pause.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
    new KeyValue(obBorder.backgroundProperty(),
        new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)))));