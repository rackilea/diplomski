private Node replaceSceneContent(String fxml) throws Exception {
    FXMLLoader loader = new FXMLLoader();
    loader.setBuilderFactory(new JavaFXBuilderFactory());
    loader.setLocation(Main.class.getResource(fxml));

    BorderPane page = loader.load();
    MenuController controller = loader.getController();

    page.setOnKeyPressed(event -> {
        switch (event.getCode()) {
        case F11:
            if (stage.isFullScreen()) {
                stage.setFullScreen(false);
            } else {
                stage.setFullScreen(true);
            }
            break;
        default:
            break;
        }
    });
    Scene scene = new Scene(page);
    scene.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.A) {
            controller.printA();
        }
    });


    page.prefWidthProperty().bind(scene.widthProperty());
    page.prefHeightProperty().bind(scene.heightProperty());
    stage.setScene(scene);
    return controller ;
}