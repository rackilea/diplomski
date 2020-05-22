private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {   

    DefaultTableModel model = (DefaultTableModel)table.getModel();

    coffee coff = new coffee(name.getText(),coffeeName.getText(),Integer.parseInt(coffeePrice.getText()),buttonGroup1.getSelection().getActionCommand(),(Integer)quanOrder.getValue());

    coffeeArray.add(coff);

    //Remove all rows before adding everything from ArrayList.
    for(int i = 0; i < model.getRowCount(); i++)
        model.removeRow(i);

    for(int i = 0; i < coffeeArray.size(); i++)
    {
       String customerName = coffeeArray.get(i).getName();
       String cofName = coffeeArray.get(i).getCoffeeName();
       int price = coffeeArray.get(i).getuPrice();
       String OrderMode= coffeeArray.get(i).isOrderMode();
       int quantity = coffeeArray.get(i).getQuanOrder();

       Object[] rowCoffee = {customerName,cofName,price,OrderMode,quantity};

       model.addRow(rowCoffee);
    }