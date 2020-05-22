public void accountAPP(){
        //Initialize all your JFrames, JPanels etc.

        //call the method to get generated Map.
        Map<String, String> accDetails = fetchAccountDetailsFromFile(ACCOUNT_FILE_PATH);

        //Combo Box
        JComboBox<String> accountNumbers = new JComboBox<>();

        //Text Field for customerName
        JTextField customerName = new JTextField(20);

        //Text Field for balance
        JTextField balance = new JTextField(20);

        /*
         * Iterate through your keySet from the accDetails map
         * and add each key (acct. numbers) to the Combo box.
         */



        for(String accountNumber : accDetails.keySet()){
            accountNumbers.addItem(accountNumber);
        }

       /*
        * Add action listener for the combo box which will set the
        * text fields on account number selection.
        * (This is Java 7 style of adding an ActionListener)
        */
        accountNumbers.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAccountNo = (String)accountNumbers.getSelectedItem();
                String custNameAndBal = accDetails.get(selectedAccountNo);

                // split the value obtained at '|' to get name and balance.
                String[] nameBalDetails = custNameAndBal.split("\\|");
                customerName.setText(nameBalDetails[0]);
                balance.setText(nameBalDetails[1]);

            }
        });

        /*
         * Add your components to JFrame and follow with your other business logic
         */ 

    }