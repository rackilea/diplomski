void updateButtonState() {
    boolean enabled = checkEditText(numberRoom);
    if (enabled) {
        goToRoom.setBackgroundColor(0xFFFFFFFF);
        goToRoom.setEnabled(enabled);
    } else {
        //change them back to disabled state
    }
}