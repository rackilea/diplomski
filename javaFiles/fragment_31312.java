private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
    if (evt.getSource().equals(calculateButton)) {
        int1 = Double.parseDouble(amountTextField.getText());
        int2 = Double.parseDouble(rateTextField.getText());
        int3 = Double.parseDouble(periodsTextField.getText());
        result = compoundMethod(int1, int2, int3);
        resultTextField.setText(String.valueOf(result));

    }
}