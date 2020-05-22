public class ClickTest extends ApplicationTest {

    @Test
    public void testClick() {
        verifyThat(".button", hasText("click me!"));
        clickOn(".button");
        verifyThat(".button", hasText("clicked!"));
    }

    /**
     * Use glass robot.
     * Note: this must happen once before the class is loaded. Otherwise,
     * the very first test run uses the awt robot
     */
    @BeforeClass
    public static void config() throws Exception {
        System.getProperties().put("testfx.robot", "glass");
    }

    @Override
    public void start(Stage stage) {
        Parent sceneRoot = new ClickPane();
        Scene scene = new Scene(sceneRoot, 100, 100);
        stage.setScene(scene);
        stage.show();
    }

    // scene object for unit tests
    public static class ClickPane extends StackPane {
        public ClickPane() {
            super();
            Button button = new Button("click me!");
            button.setOnAction(actionEvent -> button.setText("clicked!"));
            getChildren().add(button);
        }
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger
            .getLogger(ClickTest.class.getName());
}