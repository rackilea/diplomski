KeyFrame update = new KeyFrame(Duration.seconds(0.5), event -> { 
    // update label here. You don't need to use Platform.runLater(...), because Timeline makes sure it will be called on the UI thread.
}); 
Timeline tl = new Timeline(update); 
tl.setCycleCount(Timeline.INDEFINITE);
tl.play();