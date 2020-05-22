for(WebElement el : allOptions) {
    // So you can get the text like:-
    String text = el.getText();
    if(text.equals("specific value")) {
        // Your operation that you want to do once string matches.
    }
}