private void displayLetters(final String letter) {
    newDisplayWord = editText.getText().toString();
    newDisplayWord = newDisplayWord + letter;

    editText.setText(newDisplayWord);
}