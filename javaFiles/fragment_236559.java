// Create a wrapper Pane first
    Pane wrapperPane = new Pane();
    borderPane.setCenter(wrapperPane);
    // Put canvas in the center of the window
    Canvas canvas = new Canvas();
    wrapperPane.getChildren().add(canvas);
    // Bind the width/height property to the wrapper Pane
    canvas.widthProperty().bind(wrapperPane.widthProperty());
    canvas.heightProperty().bind(wrapperPane.heightProperty());
    // redraw when resized
    canvas.widthProperty().addListener(event -> draw(canvas));
    canvas.heightProperty().addListener(event -> draw(canvas));
    draw(canvas);