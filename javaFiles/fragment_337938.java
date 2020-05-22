model1 = new DefaultTableModel();
model1.addColumn("Purpose");
model1.addColumn("Name");
model1.addColumn("Composition");
model1.addColumn("Expiry");
model1.addColumn("Stock");
model1.addColumn("Cost");
model1.addColumn("Type");
model1.addColumn("Supplier");
model1.addColumn("Supplier Number");
model1.addColumn("Rack");

for (int index = 0; index < 10; index++) {

    Vector vector = new Vector();
    vector.add("p" + index);
    vector.add("n" + index);
    vector.add("c" + index);
    vector.add("e" + index);
    vector.add("s" + index);
    vector.add("c" + index);
    vector.add("t" + index);
    vector.add("s" + index);
    vector.add("s" + index);
    vector.add("r" + index);

    model1.addRow(vector);

}

table1 = new JTable(model1);
Color ivory = new Color(255, 255, 208);
table1.setOpaque(true);
table1.setFillsViewportHeight(true);
table1.setBackground(ivory);

JScrollPane scroll1 = new JScrollPane(table1);
table1.getTableHeader().setBackground(ivory);
add(scroll1, BorderLayout.CENTER);