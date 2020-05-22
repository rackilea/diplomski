List<String> liste; // this could be declared a field

    ComboBox<String> cB = ...
    ...

    // create fixed sized list with initial values
    liste = Arrays.asList(cB.getValue(), tFID.getText(), tFName.getText(), tFWert.getText());

    // register listeners that modify a certain element of liste on change
    cB.valueProperty().addListener(new ListModifyingChangeListener(0, liste));
    tFID.textProperty().addListener(new ListModifyingChangeListener(1, liste));
    tFName.textProperty().addListener(new ListModifyingChangeListener(2, liste));
    tFWert.textProperty().addListener(new ListModifyingChangeListener(3, liste));