stage.widthProperty().addListener(event -> {
        rightPane.setPrefWidth(stage.getWidth()/2);
        rightPane.relocate(stage.getWidth()/2,0);
    });

    stage.heightProperty().addListener(event -> {
        rightPane.setPrefHeight(stage.getHeight());
    });

    root.getChildren().add(pane);