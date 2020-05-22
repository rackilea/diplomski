public void handleButton2(){

    String[] letters = {"a", "b", "c", "2"};

    buttonPressDelay.setOnFinished(e -> {
        sms_text_area.appendText(letters[buttonClickCount]);
        lastButtonClicked = null ;
    });

    if (lastButtonClicked == button_2) {
        buttonClickCount = (buttonClickCount + 1) % letters.length ;
    } else {
        buttonClickCount = 0 ;
    }
    buttonPressDelay.playFromStart();
    lastButtonClicked = button_2 ;
}