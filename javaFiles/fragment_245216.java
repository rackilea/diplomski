public void actionPerformed(ActionEvent addCusHandler) { 
    int StateIndex; 
    try { 
        File file = new File("Customer.txt");
        StringBuilder sb = new StringBuilder();
        boolean success = file.createNewFile();
        if (success) {
            ExistTextCustomers
            .setText("Customer.txt file created file added");
        } else if (file.canWrite()) {
            ExistTextCustomers
            .setText("Writing data to Customer.txt, file added");
        } else {
            ExistTextCustomers.setText("Cannot create file: Customer.txt");
        }
        try {
            FileWriter fileW = new FileWriter("Customer.txt", true);
            sb.append(NameText.getText());
            sb.append(",");
            sb.append(AddressText.getText());
            sb.append(",");
            sb.append(CityText.getText());
            sb.append(",");
            StateIndex = StateList.getSelectedIndex();
            sb.append(states[StateIndex]);
            sb.append(",");
            sb.append(ZipText.getText());
            sb.append(",");
            sb.append(PhoneText.getText());
            sb.append("\r\n");
            fileW.write(sb.toString());
            parent.setField(sb.toString());
            fileW.close();
            ExistTextCustomers.setText("A new Customer has been added!");
            FileReader fileR = new FileReader("Customer.txt");
            BufferedReader buffIn = new BufferedReader(fileR);
            String textData = buffIn.readLine();
            buffIn.close();