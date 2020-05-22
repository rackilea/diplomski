class Toolbar {

    private List<ValueSubmittedListener> listeners = new ArrayList<ValueSubmittedListener>();


    public void addListener(ValueSubmittedListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ValueSubmittedListener listener : listeners) {
            listener.onSubmitted(textfield.getText());
        }
    }

}