private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {   

    DefaultTableModel model = (DefaultTableModel)table.getModel();

    coffee coff = new coffee(name.getText(),coffeeName.getText(),Integer.parseInt(coffeePrice.getText()),buttonGroup1.getSelection().getActionCommand(),(Integer)quanOrder.getValue());

    coffeeArray.add(coff);

    //Instead of going through the for loop, adding objects you already have, just add the one you just added to the model.

    model.addRow( new Object[] {coff.getName(), coff.getCoffeeName(), coff.getuPrice(), coff.isOrderMode(), coff.getQuanOrdered() } );