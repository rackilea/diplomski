@Override
public void start(Stage primaryStage) {
    MeshView box = createCuboid(100, 30, 50);
    PhongMaterial material = new PhongMaterial();
    Patterns pattern = new Patterns(300, 160);
    material.setDiffuseMap(pattern.createPattern(Patterns.CarbonPatterns.CARBON_KEVLAR, false));
    box.setMaterial(material);
    box.getTransforms().addAll(rotateX, rotateY);
    Scene scene = new Scene(new Group(box), 500, 400, true, SceneAntialiasing.BALANCED);

    primaryStage.setScene(scene);
    primaryStage.show();
}