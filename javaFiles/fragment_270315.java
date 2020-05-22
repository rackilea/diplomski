KeyFrame kf1 = new KeyFrame(Duration.seconds(0), new KeyValue(imageViewHover.opacityProperty(), 0));
        KeyFrame kf2 = new KeyFrame(Duration.seconds(.5), new KeyValue(imageViewHover.opacityProperty(), 1));
        KeyFrame kf3 = new KeyFrame(Duration.seconds(1.5), new KeyValue(imageViewHover.opacityProperty(), 1));
        KeyFrame kf4 = new KeyFrame(Duration.seconds(2), new KeyValue(imageViewHover.opacityProperty(), 0));
        Timeline timelineOn = new Timeline(kf1, kf2, kf3, kf4);
        timelineOn.setCycleCount(Timeline.INDEFINITE);