Apply.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            name = nameField.getText();
            employeeID = IDField.getText();
            rateOfPay = payRateField.getText();
            hoursWorked = hoursField.getText();
            setVisible(false);
            NewListener.this.pd.addButton(name, employeeID, rateOfPay, hoursWorked);
        }
    });