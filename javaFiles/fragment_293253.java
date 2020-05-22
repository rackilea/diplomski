down.setOnAction ( e -> {

     TranslateTransition transition = new TranslateTransition();
     transition.setDuration(Duration.millis(2500));
     transition.setNode(circledd);

     transition.setByX(50); //horizontaliai
     transition.setByY(0);  //Vertikaliai
     transition.setAutoReverse(false);

     down.setDisable(true);
     transition.setOnFinished(evt -> down.setDisable(false));

     transition.play();
 });