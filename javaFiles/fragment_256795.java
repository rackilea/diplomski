if (anyEvent.getSource() == decrement) {
    info = label.getText();
    dec = Integer.parseInt(info);
    dec = dec - 1;
    info = Integer.toString(dec);
    label.setText(info);
} else if (anyEvent.getSource() == increment) {
    info = label.getText();
    dec = Integer.parseInt(info);
    dec = dec + 1;
    info = Integer.toString(dec);
    label.setText(info);
}