cityCombobox1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            selCity1 = cityCombobox1.getSelectedItem().toString();
            if(itr.next() == "Non-Citadel"){
                outlet.populateTable(outletList1, selCity1); // data is getting filled here.
            }
        }