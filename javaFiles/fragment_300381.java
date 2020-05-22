rdo1.selectedProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue) {
        System.out.println("ONE Selected!");
    } else {
        System.out.println("ONE deselected!");
    }
});