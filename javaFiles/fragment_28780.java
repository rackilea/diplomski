private void checkConditions(JFormattedTextField fieldA, JFormattedTextField fieldB) {
    // Make sure something is contained within fieldA and 
    // that it's actually numerical text.
    if(!fieldA.getText().isEmpty() && 
                fieldA.getText().matches("([-]?)\\d+([,]\\d+)?(([.]\\d+)?)")) {
        // Convert the supplied text to Double and
        // ensure the desired numerical formating.
        String res = (String)tausenderPunkt(Double.parseDouble(fieldA.getText().replace(",","")));
        fieldA.setText(res);
        // Set Focus to our next text fieldB.
        fieldB.requestFocusInWindow();
        // Highlight the contents (if any) within the
        // next text fieldB.
        fieldB.selectAll();
    }
    // If fieldA is empty or fieldA does not contain 
    // numerical text then inform User and re-highlight
    // the entry in fieldA.
    else {
        JOptionPane.showMessageDialog (null, "Please Enter Numerical Values Only!", 
                "Incorrect Entry", JOptionPane.WARNING_MESSAGE);
        fieldA.selectAll();
    }
}