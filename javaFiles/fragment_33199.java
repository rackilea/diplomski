Timeline timeline = new Timeline();
for (int i=0; i<buttoncount; i++) {
    timeline.getKeyFrames().add(new KeyFrame(Duration.millis((i+1)*1000), e -> {
        // Change highlighted button
    });
} 
timeline.play();