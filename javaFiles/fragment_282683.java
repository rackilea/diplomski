comboBox.getEditor().addEventFilter(KeyEvent.KEY_PRESSED, e -> {

    if (e.getCode() == KeyCode.ENTER) {
        System.out.println( "Enter pressed");
    }

});