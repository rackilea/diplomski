private static void runWhenSkinned(final Control control, final Runnable operation) {
    final ReadOnlyObjectProperty<?> skinProperty = control.skinProperty();
    if (skinProperty.get() == null) {
        // Run after the control has been skinned
        skinProperty.addListener(observable -> Platform.runLater(operation));
    } else {
        // Run now, since the control is already skinned
        operation.run();
    }
}

public static <T> void center(final ComboBox<T> comboBox) {
    runWhenSkinned(comboBox, () -> {
        // Get the width of the combo box arrow button
        final Region arrow = (Region)comboBox.lookup(".arrow-button");
        final double arrowWidth = arrow.getWidth();

        // Create a centered button cell
        final ListCell<T> buttonCell = new CenteredListCell<T>();
        comboBox.setButtonCell(buttonCell);

        // Create an insets object with uneven horizontal padding
        final Insets oldPadding = buttonCell.getPadding();
        final Insets newPadding = new Insets(oldPadding.getTop(),
                arrowWidth, oldPadding.getBottom(), 0);

        // Replace the default cell factory
        comboBox.setCellFactory(listView -> new CenteredListCell<T>() {
            { setPadding(newPadding); }
        });
    });
}