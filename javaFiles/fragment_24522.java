stage.widthProperty().addListener(event -> {
        rightPane.setPrefWidth(stage.getWidth()/2);
        rightPane.relocate(stage.getWidth()/2,0);
        bottomPane.setPrefWidth(stage.getWidth()-rightPane.getPrefWidth());
    });

    stage.heightProperty().addListener(event -> {
        rightPane.setPrefHeight(stage.getHeight());
        bottomPane.setPrefHeight(100); // change 100 to how high you want your bottomPane to be
        //if you want your bottomPane's height to be half the height of the window use this:  bottomPane.setPrefHeight(stage.getHeight()/2);
        bottomPane.relocate(0,stage.getHeight() - bottomPane.getPrefHeight());
        bottomPane.toFront();
    });