@Override
public void start(Stage primaryStage) {
    VBox vbox = new VBox();
    vbox.setStyle("-fx-background-color: blue;");

    for (int i = 0; i < 4; i++) {
        Button button = new Button(Integer.toString(i));
        button.getStyleClass().setAll("button");
        vbox.getChildren().add(button);
    }

    Scene scene = new Scene(vbox);
    scene.getStylesheets().add("style.css");
    primaryStage.setScene(scene);
    primaryStage.show();
}