private void updateToggleButtonStates(ToggleButton[][] buttons, int x, int y) {
    for (int i = 0 ; i < buttons.length ; i++) {
        for (int j = 0 ; j < buttons[i].length ; j++) {
            buttons[i][j].setDisable(Math.abs(i-x) > 1 || Math.abs(j-y) > 1);
        }
    }
}