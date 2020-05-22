firstNameFilterTextField.textProperty().addListener((obsVal, oldValue, newValue) -> {
        filterList.setPredicate(person -> person.getFirstName().contains(firstNameFilterTextField.getText()) 
           && person.getLastName().contains(lastNameFilterTextField.getText()));
    });
    lastNameFilterTextField.textProperty().addListener((obsVal, oldValue, newValue) -> {
        filterList.setPredicate(person -> person.getFirstName().contains(firstNameFilterTextField.getText()) 
           && person.getLastName().contains(lastNameFilterTextField.getText()));
    });