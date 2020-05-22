@Override
public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    root.setBackground(new Background(
            new BackgroundImage(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Siberischer_tiger_de_edit02.jpg/800px-Siberischer_tiger_de_edit02.jpg"),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(0, 0, false, false, false, true)
            )));

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Test Image Resizing");
    primaryStage.setScene(scene);
    primaryStage.show();
}