@Override
public void start(Stage primaryStage) {
    final MyControl control = new MyControl();
    Button btn = new Button("Say 'Hello World'");
    btn.setOnAction((ActionEvent event) -> {
        control.setText("Hello World!");
    });

    Scene scene = new Scene(new VBox(10, btn, control));

    primaryStage.setScene(scene);
    primaryStage.show();
}