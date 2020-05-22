doctor doc = new doctor();
doc.addPropertyChangeListener("change", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object newValue = evt.getNewValue();
        if (newValue instanceof String) {
            ta.setText(newValue.toString());
        } else if (newValue == null) {
            ta.setText(null);
        }
    }
});
add(doc);