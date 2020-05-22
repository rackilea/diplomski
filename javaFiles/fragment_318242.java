char[] jlabelText = yourJLabel.getText().toCharArray();

for (int i = 0; i < word.length(); i++) {
    if (word.charAt(i) == userEnteredChar) {
        jlabelText[3 * i] = ' ';
        jlabelText[3 * i + 1] = userEnteredChar;
    }
}

yourJLabel.setText(String.valueOf(jlabelText));