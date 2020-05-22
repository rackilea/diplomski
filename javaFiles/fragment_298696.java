private void animatePane() {
    boolean first_active = true;

    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {            

        if(first_active){
            fadeInPane(FIRST_PANE);
            first_active = false;
        }else{
            first_active = true;
            fadeInPane(SECOND_PANE);
        }
    }),
         new KeyFrame(Duration.seconds(30))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
}