public MyButton {
    protected List<ButtonListener> buttonListeners;

    public void addButtonListener(ButtonListener listener) {
       ...
    }

    public void removeButtonListener(ButtonListener listener) {
       ...
    }

    protected void fireButtonEvent() {
       ...
    }
}