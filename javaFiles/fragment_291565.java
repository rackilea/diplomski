public void actionPerformed(ActionEvent e) {
    JTextField[] fields = {theApp.txtR, theApp.txtG, theApp.txtB};
    int[] colourValues = new int[3];
    int i = 0;
    boolean error = false;
    for (JTextField field : fields) {
        try {
            colourValues[i++] = Integer.parseInt(field.getText());
        }
        catch (NumberFormatException ex) {
            error = true;
            field.setText("");
        }
    }
    if (!error) {
        theApp.colour = new Color(colourValues[0], colourValues[1], colourValues[2]);
        theApp.mainText.setForeground(theApp.colour);
    } else {
        JOptionPane.showMessageDialog(null, "Please enter integer values in the fields ","Wrong input", JOptionPane.ERROR_MESSAGE);
    }
}