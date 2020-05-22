ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("test", getData());
choiceDialog.showingProperty().addListener((ov, b, b1) -> {
    if (b1) {
        choiceDialog.setContentText("");
    }else {
        choiceDialog.setContentText(null);
    }

    //or 
    if (b1) {
        Node comboBox = choiceDialog.getDialogPane().lookup(".combo-box");
        comboBox.requestFocus();
    }
});