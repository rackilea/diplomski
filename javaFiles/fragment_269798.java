accountNumbers.addActionListener(l -> {

                String selectedAccountNo = (String)accountNumbers.getSelectedItem();
                String custNameAndBal = accDetails.get(selectedAccountNo);
                String[] nameBalDetails = custNameAndBal.split("\\|");
                customerName.setText(nameBalDetails[0]);
                balance.setText(nameBalDetails[1]);
        });