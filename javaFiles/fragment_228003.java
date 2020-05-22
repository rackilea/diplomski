private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
    double amount, interest;
    int years;
    while (true) {
        try {
            amount = Double.valueOf(loanAmount.getText());
            interest = Double.valueOf(interestRate.getText());
            years = Integer.valueOf(loanYears.getText());

        } catch (NumberFormatException nfe){
            if (DEBUG) nfe.printStackTrace(System.err);
            return;
        }
    }
    // Your values of amount, interest and years will be available here.
    // Past this last curley brace, however, they will go out of scope.
    // If you want them to stick around for as long as the new object,
    // define them as class fields.
}