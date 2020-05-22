@Override public void fire() {
    // TODO (aruiz): if (!isReadOnly(isSelected()) {
    if (!isDisabled()) {
        setSelected(!isSelected());
        fireEvent(new ActionEvent());
    }
}