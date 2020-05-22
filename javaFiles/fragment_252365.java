...
private Rectangle rct_player;
private TranslateTransition transTransition;
private boolean isMoving = false;
...

    // Create the translate transition for the rectangle
    transTransition = new TranslateTransition(new Duration(75000), rct_player);
    transTransition.setToY(0);
    transTransition.setToX(1500);
    transTransition.setInterpolator(Interpolator.LINEAR);
    transTransition.setCycleCount(Timeline.INDEFINITE);

    scn_main.setOnKeyPressed(e-> {
        if (!isMoving) {
            transTransition.play();
            isMoving = true;
        }
    });
    scn_main.setOnKeyReleased(e -> {
        transTransition.stop(); 
        isMoving = false;
    });
...