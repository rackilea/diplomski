@Override
public void start(Stage primaryStage) {
    ColorPicker picker = new ColorPicker(Color.ALICEBLUE);
    Text text = new Text("Color Picker");
    VBox root = new VBox(10, text, picker);
    root.setAlignment(Pos.CENTER);

    text.fillProperty().bind(picker.valueProperty());

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}