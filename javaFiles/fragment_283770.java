table.addPropertyChangeListener("tableCellEditor", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == null) {
            // editing stopped
        } else {
            // editing started
        }
    }
};