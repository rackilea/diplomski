checkboxNuts.selectedProperty().addListener((obs, oldValue, newValue)->{
        nuts = newValue;
    });
    checkboxCherries.selectedProperty().addListener((obs, oldValue, newValue)->{
        cherries = newValue;
    });