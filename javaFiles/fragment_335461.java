for (RadioButton button : radios) {
    // prevent user interaction with button
    button.setDisable(true);

    // keep button visually the same as an enabled one
    button.setOpacity(1);
}