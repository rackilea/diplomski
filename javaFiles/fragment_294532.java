calculateButton.addActionListener(new ActionListener() {
    // calculate button action listener
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
               double salaryValue = Double.valueOf(salary.getText()); // get value from JTextField
               double tipsValue = Double.valueOf(tips.getText());
               NetPay net = new NetPay();
               double netpayValue = net.netPayRate(salaryValue, tipsValue);

            }
        });