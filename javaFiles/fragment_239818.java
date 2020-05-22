textField.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
    if(textField.getCharacters().length() == 1){
        if(e.getCode() == KeyCode.DELETE){
            if(textField.getCaretPosition() == 0){
                label.setText(text);
            }
        }
        else if(e.getCode() == KeyCode.BACK_SPACE){
            if(textField.getCaretPosition() == 1){
                label.setText(text);
            }
        }

    }
    else if(textField.getCharacters().length() == 0 && (e.getText().length() > 0)){
        if(e.getCode() != KeyCode.TAB) {
            label.setText(" ");
        }
    }
    else if((textField.getSelectedText().length() == textField.getCharacters().length()) && ((e.getCode() == KeyCode.DELETE) || (e.getCode() == KeyCode.BACK_SPACE))){
        label.setText(text);
    }
});