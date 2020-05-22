checkboxDeSelectAll.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
    if (isNowSelected) {
        checkboxSelectAllNotMandatories.setSelected(false);
    }
});

checkboxSelectAllNotMandatories.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
    if (isNowSelected) {
        checkboxDeSelectAll.setSelected(false);
    }
});