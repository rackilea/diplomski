public void start(Stage stage) throws Exception {

    VBox vbox = new VBox();

    for(int i = 0; i < 101;i++) {
        Label aLabel = new Label("Label number: " + i);
        vbox.getChildren().add(aLabel);
    }

    Scene applicationScene = new Scene(vbox);
    stage.setHeight(400.0);
    stage.setWidth(400.0);
    stage.setScene(applicationScene);
    stage.show();
}