int errors = 0;

...

char letter = aLetter.getText().charAt(0);
if (findWord.indexOf(letter) != -1) {
    if (findWord.charAt(0) == letter) char0.setText(String.valueOf(letter));
    if (findWord.charAt(1) == letter) char1.setText(String.valueOf(letter));
    if (findWord.charAt(2) == letter) char2.setText(String.valueOf(letter));
    if (findWord.charAt(3) == letter) char3.setText(String.valueOf(letter));
    ...
} else {
    // Error:
    ++errors;
    label.setText(String.valueOf(error));
}