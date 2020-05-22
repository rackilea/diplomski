public void actionPerformed(ActionEvent arg0) { 
    String name = jFrame_pName.getText().trim();
    String price = jFrame_pPrice.getText().trim();
    String quantity = jFrame_quantity.getText().trim();
    String st[] = {name, price, quantity};
    model.addRow(st);
}