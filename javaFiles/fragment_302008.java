public void MoveCircles(BorderPane borderPane,Circle circles[]){
    for (int i = 0; i < 20; i++) {
        PathTransition pathTransition2 = new PathTransition();
        pathTransition2.setNode(circles[i]);
        pathTransition2.setDuration(Duration.seconds(2));
        pathTransition2.setPath(createPath(borderPane, pathTransition2));       
        pathTransition2.play();
        pathTransition2.setInterpolator(Interpolator.LINEAR);               
        pathTransition2.setOnFinished(e -> {                        
            pathTransition2.setPath(createPath(borderPane, pathTransition2));   
            pathTransition2.play();                         
        });                                     
    }
}