@Override
public void start(Stage primaryStage) {
    Box box = new Box(100, 30, 50);
    PhongMaterial material = new PhongMaterial();
    Patterns pattern = new Patterns(100, 30);
    material.setDiffuseMap(pattern.createPattern(Patterns.CarbonPatterns.CARBON_KEVLAR, false));
    box.setMaterial(material);

    Scene scene = new Scene(new Group(box), 500, 400, true, SceneAntialiasing.BALANCED);
    primaryStage.setScene(scene);
    primaryStage.show();
}