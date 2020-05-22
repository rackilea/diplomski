int maxSeconds = ... ;
TimelineEvent[] events = ... ; // populate array of events...
Slider slider = new Slider(0, maxSeconds, 0);
TextArea textArea = new TextArea();

// ...

Timeline timeline = new Timeline();
for (TimelineEvent event : events) {
    timeline.getKeyFrames().add(new KeyFrame(event.getTime(), 
        e -> textArea.setText(event.getInfo());
}

// make slider value change with timeline:
timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, 
    new KeyValue(slider.valueProperty(), 0)));
timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(maxSeconds), 
    new KeyValue(slider.valueProperty(), maxSeconds)));

timeline.play();