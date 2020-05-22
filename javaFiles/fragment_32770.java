for(ActionListener al : btnEnter.getActionListeners())
 btnEnter.removeActionListener(al)

btnEnter.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //convert text area into double
            double depositNumber = Double.parseDouble(ta.getText());
            sav.deposit(depositNumber);
            btnWithdraw.setEnabled(true);
            btnBalance.setEnabled(true);
        }

    });