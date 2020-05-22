DefaultTableModel tableModel = new DefaultTableModel();

JTable table = new JTable(tableModel);

JPanel panel6 = new JPanel();
panel6.setLayout(new FlowLayout(FlowLayout.LEADING));
panel6.setSize(300,300);
panel6.add(new JScrollPane(table));

this.add(panel6);