Stage stage = new Stage();
    ScrollPane pane = new ScrollPane();
    TextField yourcontent = new TextField("this is an example");
    pane.setContent(yourcontent);
    pane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    Scene scene = new Scene(pane,300,300);
    stage.setScene(scene);
    stage.showAndWait();