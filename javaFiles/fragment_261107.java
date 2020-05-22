checkbox.selectedProperty().addListener((obs, oldVal, newVal) - > {

    if (!newVal) {
        // Add Username Label
        gridPane.add(new Label("Username : "), 0, 5);

        // Add Username Text Field
        gridPane.add(new TextField(), 1, 5);
        gridPane.getScene().getWindow().sizeToScene();
    }
});