task.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();
        switch (name) {
            case "progress":
                int value = (int) evt.getNewValue();
                progressBar.setValue(value);
                break;
        }
    }
});