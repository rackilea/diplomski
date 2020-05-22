... object definition ...
boolean isGreen = false;

... action listener...
Object o = evt.getSource();

if (o.equals(lblSI)) {
    if (isGreen) {
      lblSI.setBackground(Color.RED);
    } else {
      lblSI.setBackground(Color.GREEN);
    }
    isGreen = !isGreen;
}