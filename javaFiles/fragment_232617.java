import org.controlsfx.control.PopOver;
// here all other needed dependencies

public class Main extends Application {
    private static final String DATE_TYPE = "DATE";

    private class ComboBoxNode {
        private Object value;
        private String type;

        private ComboBoxNode(final Object value, final String type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return Objects.toString(value);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final ObservableList<ComboBoxNode> items =
                FXCollections.observableArrayList(
                        new ComboBoxNode(LocalDate.now(), DATE_TYPE),
                        new ComboBoxNode("11:35AM", "TIME"));

        final PopOver datePopOver = new PopOver();
        datePopOver.setTitle("Enter new date");
        datePopOver.setCornerRadius(10);
        datePopOver.setHeaderAlwaysVisible(true);
        datePopOver.setCloseButtonEnabled(true);
        datePopOver.setAutoHide(true);

        final ComboBox<ComboBoxNode> customComboBox = new ComboBox<>(items);
        customComboBox.getSelectionModel().selectedItemProperty().addListener((o, old, newNode) -> {
            if (newNode != null) {
                if (newNode.type.equals(DATE_TYPE)) {
                    final DatePicker datePicker = new DatePicker((LocalDate) newNode.value);
                    datePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
                        items.set(customComboBox.getSelectionModel().getSelectedInde‌​x(), new ComboBoxNode(newDate, DATE_TYPE));
                        datePopOver.hide();
                    });

                    final StackPane stackPane = new StackPane(datePicker);
                    stackPane.setPadding(new Insets(10, 10, 10, 10));

                    datePopOver.setContentNode(stackPane);
                    datePopOver.show(customComboBox);
                } else {
                    datePopOver.hide();
                }
            }
        });

        final FlowPane pane = new FlowPane(customComboBox);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setPrefWidth(400);
        pane.setPrefHeight(300);

        // Show Scene
        final Scene scene = new Scene(pane);
        primaryStage.setTitle("Popup calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}