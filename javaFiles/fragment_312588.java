public static class MyRadioButton extends RadioButton {
    public MyRadioButton() {
    }

    public MyRadioButton(String text) {
        super(text);
    }
    @Override
    public void fire() {
        if (!isDisabled()) {
            setSelected(!isSelected());
            fireEvent(new ActionEvent());
        }
    }
}