datePicker.getEditor().setOnKeyTyped(event -> {
    if (!"0123456789/".contains(event.getCharacter())) {
        return;
    }
    datePicker.getEditor().selectForward();
    if(!event.getCharacter().equals("/") && 
       datePicker.getEditor().getSelectedText().equals("/")){
        datePicker.getEditor().cut();
        datePicker.getEditor().selectForward();
    }
    datePicker.getEditor().cut();
});