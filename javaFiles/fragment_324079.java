@Override
public void start(Stage primaryStage) {
    TextField textField = new TextField();

    textField.setSkin(new TextFieldSkin(textField) {
        {
            // use red color for text
            setTextFill(Color.RED);
        }

    });

    StackPane root = new StackPane(textField);

    Scene scene = new Scene(root, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}