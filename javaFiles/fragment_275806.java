public class ListenerTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("You can see me");
        addListener(label);
        Button button = new Button("Hide/Show");
        button.setOnAction(e -> label.setVisible(!label.isVisible()));

        Scene scene = new Scene(new VBox(20, label, button));
        stage.setScene(scene);
        stage.show();
    }
    public static void addListener(Node node) {
        node.visibleProperty().addListener(ListenerTest::handleVisibleChanged);
    }
    private static void handleVisibleChanged(ObservableValue<?> a, Boolean b, Boolean newValue) {
        System.out.println("new value: " + newValue);
    }

    public static void main(String[] args) {
        launch();
    }
}