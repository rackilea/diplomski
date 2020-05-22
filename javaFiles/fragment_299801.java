timeline.getKeyFrames().setAll(
    new KeyFrame(Duration.ZERO,
            new KeyValue(listView.opacityProperty(), 0),
            new KeyValue(writableHeight, expansionManager.fromHeight.get()),
            new KeyValue(writableWidth, expansionManager.fromWidth.get())),
    new KeyFrame(Duration.millis(300),
            new KeyValue(listView.opacityProperty(), 1),
            new KeyValue(writableHeight, expansionManager.toHeight.get()),
            new KeyValue(writableWidth, expansionManager.toWidth.get()))
);