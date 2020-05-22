@Before
public void before() {
    Node node = generateComponentToTest();
    Parent parent = StackPaneBuilder.create().children(node).build();
    Scene scene = SceneBuilder.create().root(parent).build();

    if (this.currentStage != null) {
        this.currentStage.close();
    }

    Stage stage = new Stage();
    stage.setScene(scene);
    stage.centerOnScreen();
    stage.show();

    this.currentStage = stage;
}