final List<String> values = Arrays.asList("", "X", "O");
final GridPane gridPane /* = */:
final ComboBox<String> cb = new ComboBox<>();

public void init() {
    addButtonToGrid(6, 6);
    cb.getItems().addAll("4x4", "6x6", "8x8", "10x10");
    cb.valueProperty().addListener((observable, oldValue, newValue) -> {
        String[] size = newValue.split("x");
        addButtonToGrid(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
    });
}

private void addButtonToGrid(int sizeR, int sizeC) {
    gridPane.getChildren().clear();
    for (int i = 0; i < sizeC; i++) {
        for (int j = 0; j < sizeR; j++) {
            final Button button = new Button("");
            button.setOnAction(event -> {
                int valueIndex = values.indexOf(button.getText());
                button.setText(values.get((valueIndex + 1) % values.size()));
            });
            button.setPrefSize(35, 40);
            gridPane.add(button, i, j);
            button.setDisable(false);
        }
    }
}