public void actionPerformed(ActionEvent e) {
    JTextField[] fields = {theApp.txtR, theApp.txtG, theApp.txtB};
    int rgb = 0, i = 0;
    boolean error = false;
    for (JTextField field : fields) {
        try {
            rgb |= (Integer.parseInt(field.getText())) << (16 - i);
            i += 8;
        }
        catch (NumberFormatException ex) {
            error = true;
            field.setText("");
        }
    }
    if (!error) {
        theApp.colour = new Color(rgb);
        theApp.mainText.setForeground(theApp.colour);
    } else {
        JOptionPane.showMessageDialog(null, "Please enter integer values in the fields ","Wrong input", JOptionPane.ERROR_MESSAGE);
    }
}