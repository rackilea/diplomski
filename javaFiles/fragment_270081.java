class ButtonState {
    private static ButtonState instance = new ButtonState();
    private Button state

    public ButtonState getInstance() {
        return instance;
    }

    public void setState(Button value) {
        state = value;
    }

    public Button getState() {
        return state;
    }
}