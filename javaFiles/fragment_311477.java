private double aspect = 1.0;

aspectCheckBox.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        preserveAspectActionPerformed(evt);
    }
});    

private void preserveAspectActionPerformed(java.awt.event.ActionEvent evt) {                                           

    try {
        double w = Double.parseDouble(widthField.getText());
        double h = Double.parseDouble(heightField.getText());
        aspect = w / h;            
    } 
    catch(NumberFormatException ex) {
        // ... error occurred due to non-numeric input
        // (use a JSpinner or JFormattedTextField to avoid this)
    }
}