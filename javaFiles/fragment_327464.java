model.addSelectionChangeListener(new PropertyChangeListener() {
    public void propertyChange(PropertyChangeEvent evt) {
        setBackground(Boolean.TRUE == evt.getNewValue()? Color.GREEN : Color.YELLOW);
        // probably some another changes
    }
});