filteredList.predicateProperty().bind(Bindings.createObjectBinding(() ->
    person -> person.getFirstName().contains(firstNameFilterTextField.getText())
           && person.getLastName().contains(lastNameFilterTextField.getText()),

    firstNameFilterTextField.textProperty(),
    lastNameFilterTextField.textProperty()

));