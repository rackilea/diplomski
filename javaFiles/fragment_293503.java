public class Blubb extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button_1 = new Button("Button #1");
        button_1.setTooltip(new Tooltip("Blubb #1"));

        StackPane primary = new StackPane(new BorderPane(button_1));
        primaryStage.setScene(new Scene(primary, 320, 240));
        addStageFocusListener(primaryStage, primary);
        primaryStage.show();

        Button button_2 = new Button("Button #2");
        button_2.setTooltip(new Tooltip("Blubb #2"));

        StackPane second = new StackPane(new BorderPane(button_2));
        Stage secondStage = new Stage();
        addStageFocusListener(secondStage, second);
        secondStage.setScene(new Scene(second, 320, 240));
        secondStage.show();
    }

    public void addStageFocusListener(Stage stage, StackPane stackPane) {
        stage.focusedProperty().addListener(new ChangeListener<Boolean>(){
            public final StackPane preventTooltip = new StackPane();
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(stage.isFocused()) {
                    if(stackPane.getChildren().contains(preventTooltip)) {
                        stackPane.getChildren().remove(preventTooltip);
                    }
                } else {
                    stackPane.getChildren().add(preventTooltip);
                }
            }
        });
    }
}