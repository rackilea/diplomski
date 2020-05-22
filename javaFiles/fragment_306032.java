@Override
public void start(Stage primaryStage) throws Exception {
    String[] options = new String[]{"A", "B", "C", "D", "E", "F"};
    GridPane grid = new GridPane();

    for (int i = 0; i < options.length; i++) {
        final int row = i;
        String option = options[i];
        CheckBox checkBox = new CheckBox(option);

        ChoiceBox<Integer> choice = new ChoiceBox<>();
        Label label = new Label("How many of the selected accounts do you have?");
        choice.getItems().addAll(1, 2, 3, 4, 5);

        VBox choiceContainer = new VBox(label, choice);

        checkBox.selectedProperty().addListener((o, oldValue, newValue) -> {
            if (newValue) {
                grid.add(choiceContainer, 1, row);
            } else {
                grid.getChildren().remove(choiceContainer);
            }
        });

        grid.add(checkBox, 0, row);
    }

    Scene scene = new Scene(grid);

    primaryStage.setScene(scene);
    primaryStage.show();
}