class PersonForm extends BorderPane {
    Button closeButton;
    TextField nameField;
    TextField ageField;

    public PersonForm() {
        this.nameField = new TextField(...);
        this.ageField = new TextField(...);
        this.closeButton = new Button("Close Window");

        // set layouts of buttons here.

        if (Global.nameFieldValue != null) {
            this.nameField.setText(Global.nameFieldValue);
        }
        if (Global.passwordFieldValue != null) {
            this.passwordField.setText(Global.passwordFieldValue);
        }

        PersonForm thisForm = this; // So that EventHandler cna use this.
        this.closeButton.setOnAction(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Global.nameFieldValue = thisForm.nameField.getText();
                Global.passwordFieldValue = thisForm.passwordField.getText();
                // switch screens.
            }
        });
    }
}