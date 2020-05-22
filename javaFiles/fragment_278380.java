letter[x][y].selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
    if (isNowSelected) {
        updateToggleButtonStates(letter, x, y);
    } else {
        // not sure if you want to do something when buttons are deselected?
    }
});