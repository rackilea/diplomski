enter.setOnAction( event -> {
    if(text1.isFocused()) {
       text2.requestFocus();
    } else if(text2.isFocused()) {
       text3.requestFocus();
    }
});