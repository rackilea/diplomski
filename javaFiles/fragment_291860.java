public static class FixedCheckBoxTableCell<S, T> extends CheckBoxTableCell<S, T> {

    @Override
    public void updateItem(T item, boolean empty) {
        checkCallback();
        super.updateItem(item, empty);
    }

    private void checkCallback() {
        if (getSelectedStateCallback() != null) return;
        ObservableValue<Boolean> observable = 
                (ObservableValue<Boolean>) getTableColumn().getCellObservableValue(getIndex());
        // handled by super
        if (observable instanceof BooleanProperty) return;
        // can't bidi-bind anyway
        if (!(observable instanceof Property)) return;
        // getting here if we have a ObjectProperty<Boolean>, that's not handled by super
        setSelectedStateCallback(index -> {
            ObjectProperty<Boolean> p = (ObjectProperty<Boolean>) getTableColumn().getCellObservableValue(index);
            return BooleanProperty.booleanProperty(p);
        });
    }


}