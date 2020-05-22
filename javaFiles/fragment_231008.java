// Instead of all the Task, only : 
Timeline timeline = new Timeline();
final KeyValue kv = new KeyValue(arc.rotateProperty(), 1800);
final KeyFrame kf = new KeyFrame(Duration.millis(5000), kv);
timeline.getKeyFrames().add(kf);
timeline.play();
timeline.setOnFinished(e -> label.setText("Stop"));