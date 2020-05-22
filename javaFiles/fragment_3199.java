datePicker.getEditor().setOnKeyTyped(event -> {
    if (!"0123456789/".contains(event.getCharacter())) {
        return;
    }
    datePicker.getEditor().selectForward();
    datePicker.getEditor().cut();
});