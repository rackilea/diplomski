Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), 
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                snake.updatePosition();
            }
        }
    ));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();