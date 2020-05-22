@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Say 'Hello World'");
    btn.setOnAction((ActionEvent event) -> {
        System.out.println("Hello World!");
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 500, 500);

    Image image = new Image("http://i.stack.imgur.com/OHj1R.png");
    CursorSimulator simulator = new CursorSimulator(image, scene, root.getChildren(), 32, 50);
    scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

        private boolean fadeOut = true;

        @Override
        public void handle(MouseEvent event) {
            if (fadeOut) {
                simulator.fadeOut();
            } else {
                simulator.fadeIn();
            }
            fadeOut = !fadeOut;
        }
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}