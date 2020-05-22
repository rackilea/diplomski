int rowCounter = fields.size()+1;             
pnlRows.add(new JLabel("Row " + rowCounter));
JTextField field = new JTextField(20);
pnlRows.add(field);
fields.add(field);
pnlRows.revalidate();
validate();