Timeline t = new Timeline(
                    new KeyFrame(Duration.seconds(0), new KeyValue(btn[d - 1].opacityProperty(), .1)),
                    new KeyFrame(Duration.seconds(0.5), new KeyValue(btn[d - 1].opacityProperty(), 1))
            );
t.setAutoReverse(true);
t.setCycleCount(Timeline.INDEFINITE); 
t.play();