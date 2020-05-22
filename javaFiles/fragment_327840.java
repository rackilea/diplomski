public String getCurrentlyTypedWord() {//get newest word after last white spaceif any or the first word if no white spaces
    String text = textField.getText();
    String wordBeingTyped = "";
    if (text.contains(" ")) {
        int tmp = text.lastIndexOf(" ");
        if (tmp >= currentIndexOfSpace) {
            currentIndexOfSpace = tmp;
            wordBeingTyped = text.substring(text.lastIndexOf(" "));
        }
    } else {
        wordBeingTyped = text;
    }
    return wordBeingTyped.trim();
}