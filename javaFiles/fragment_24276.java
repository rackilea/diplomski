public class TableClass {
     DefaultTableModel model;

     public TableClass() {
        model = new DefaultTableModel();
        table_1.setModel(model);
        model.addColumn("Product Name");
        model.addColumn("Product Price");
        model.addColumn("Quantity"); 


        JButton addButton = JButton("Add");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 String name = jFrame_pName.getText().trim();
                 String price = jFrame_pPrice.getText().trim();
                 String quantity = jFrame_quantity.getText().trim();
                 String st[] = {name, price, quantity};
                 model.addRow(st);
            }
        })
     }
}