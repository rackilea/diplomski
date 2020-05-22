textfield.getScene().getAccelerators().put(new KeyCodeCombination(
    KeyCode.C, KeyCombination.CONTROL_ANY), new Runnable() {
    @Override public void run() {
        //Insert conditions here
        textfield.requestFocus();
    }
});