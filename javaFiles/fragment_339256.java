class InputFilter implements ChangeListener<String> {
    private ComboBox<ComboBoxItem> box;
    private FilteredList<ComboBoxItem> items;

    public InputFilter(ComboBox<ComboBoxItem> box, FilteredList<ComboBoxItem> items) {
        this.box = box;
        this.items = items;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        String value = newValue;
        // If any item is selected we get the first word of that item.
        String selected = box.getSelectionModel().getSelectedItem() != null
                ? box.getSelectionModel().getSelectedItem().getText() : null;

        // If an item is selected and the value of in the editor is the same
        // as the selected item we don't filter the list.
        if (selected != null && value.equals(selected)) {
            items.setPredicate(item -> {
                return true;
            });
        } else {
            // This will most likely change the box editor contents
            items.setPredicate(item -> {
                if (item.getText().toUpperCase().startsWith(value.toUpperCase())) {
                    return true;
                } else {
                    return false;
                }
            });

            // Restore the original search text since it was changed
            box.getEditor().setText(value);
        }

        //box.show(); // <-- Uncomment this line for a neat look
    }
}