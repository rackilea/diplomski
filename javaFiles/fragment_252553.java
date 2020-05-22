ComboBox<String> combo = new ComboBox<>();
combo.setItems(FXCollections.observableArrayList("First", "Second", "Third", "Fourth"));

combo.buttonCellProperty().bind(Bindings.createObjectBinding(() -> {

    int indexOf = combo.getItems().indexOf(combo.getValue());

    Color color = Color.TRANSPARENT;

    switch (indexOf) {
    case 0: color = Color.GREEN; break;
    case 1: color = Color.RED; break;
    default: break;
    }

    final Color finalColor = color;

    // Get the arrow button of the combo-box
    StackPane arrowButton = (StackPane) combo.lookup(".arrow-button");


    return new ListCell<String>() {

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setBackground(Background.EMPTY);
                setText("");
            } else {
                setBackground(new Background(new BackgroundFill(finalColor, CornerRadii.EMPTY, Insets.EMPTY)));
                setText(item);
            }

            // Set the background of the arrow also
            if (arrowButton != null)
                arrowButton.setBackground(getBackground());
        }

    };
}, combo.valueProperty()));