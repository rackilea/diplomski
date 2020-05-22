@Override
    public void start(Stage stage) {
        final Button button = new Button("Click me!");

        button.setOnAction(e-> GluonPlatformFactory.getPlatform().vibrate());

        StackPane root = new StackPane(button);

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());

        stage.setScene(scene);
        stage.show();
    }