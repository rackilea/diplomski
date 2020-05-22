// If decrement action...
if (anyEvent.getSource() == decrement) {
    // Decrement value...
    info = label.getText();
    dec = Integer.parseInt(info);
    dec = dec - 1;
    info = Integer.toString(dec);
    label.setText(info);
// If increment action...
} else if (anyEvent.getSource() == increment) {
    // Get the text...???
    info = label.getText();
}

// And then increment the value when all else is done...
dec = Integer.parseInt(info);
dec = dec + 1;
info = Integer.toString(dec);
label.setText(info);