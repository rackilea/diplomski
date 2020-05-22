// loop through all the JLabel texts
for (int i = 0; i < LABELS.length; i++) {
    String text = LABELS[i];  // get the array item

    // use it to get the JTextField associated with this String
    JTextField textField = labelFieldMap.get(text);
    // same for the error JLabel
    JLabel errorLabel = errorLabelMap.get(text);

    // get our current JTextField's border which is a compound border
    CompoundBorder myBorder = (CompoundBorder) textField.getBorder();

    // the insideBorder, the original JTextField's border, will be unchanged
    Border insideBorder = myBorder.getInsideBorder();

    // if the text field is empty (and not the last jtext field)
    if (i < LABELS.length - 1 && textField.getText().trim().isEmpty()) {
        errorLabel.setText(ERROR_MESSAGE);  // set the error JLabel

        // set txt field's color if we want
        textField.setBackground(ERROR_BG_COLOR); 

        // okToTransfer = false;

        // create a compound border, the outer border now a line border, RED
        Border outsideBorder = BorderFactory.createLineBorder(Color.RED);
        CompoundBorder newBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);

        // set the JTextField's border to this one
        textField.setBorder(newBorder);
    } else {
        // else all OK
        errorLabel.setText(" ");
        textField.setBackground(Color.WHITE);

        // set the JTextField's border back to our original compound border
        Border outsideBorder = BorderFactory.createLineBorder(BACKGROUND);
        CompoundBorder newBorder = BorderFactory.createCompoundBorder(outsideBorder,
                insideBorder);
        textField.setBorder(newBorder);
    }
    System.out.println(text + " " + textField.getText());
}