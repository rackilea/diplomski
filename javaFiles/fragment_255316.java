jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Store selected value
                selectedName = (String) jComboBox1.getSelectedItem();

                // Create Connection and pass selected value to getEmpLastName
                createConnection c1 = new createConnection();
                names = c1.getEmpLastName(selectedName);

                // Clear your second comboBox and fill with data
                jComboBox2.removeAllItems();                
                for (String lastName : names) {
                    jComboBox2.addItem(lastName);
                }              
            }
        });