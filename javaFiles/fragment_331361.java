public void changeWidth(final Pane/*Region*/ node, double width) {//its a Pane or Regions
    this.node = node;
    this.timeline = TimelineBuilder.create()
        .keyFrames(
            new KeyFrame(Duration.millis(20),    
                new KeyValue(    going here?   , width, WEB_EASE)
            )
        )
        .build();

    setCycleDuration(Duration.seconds(5));
    setDelay(Duration.seconds(0));
}