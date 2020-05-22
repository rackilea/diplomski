public static SceneData loadSceneFromFXML(final String fxmlFile, final Controller controller) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainClass.class.getResource(fxmlFile));
    if (controller != null) {
        fxmlLoader.setController(controller);
    }
    Parent root = (Parent) fxmlLoader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(CSS);
    return new SceneData(scene, controller);
}