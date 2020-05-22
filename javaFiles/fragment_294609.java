current = Integer.parseInt(guessTextField.getText().trim()); 
if (!firstTime) {
    if (getUserInput > previous) {
        getContentPane().setBackground(Color.red);
    } else {
        getContentPane().setBackground(Color.blue);
    }
}