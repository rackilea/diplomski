gui() {
DefaultTableModel model = new DefaultTableModel(data,columnNames);
JTable table =  new JTable(model);
JScrollPane scrollPane = new JScrollPane(table);

JButton next = new JButton("next");
JButton prev = new JButton("prev");
next.addActionListener(this);
prev.addActionListener(this);
JPanel panel = new JPanel(new BorderLayout());
JPanel buttonPanel = new JPanel();
buttonPanel.add(prev);
buttonPanel.add(next);
panel.add(buttonPanel, BorderLayout.SOUTH);
panel.add(table.getTableHeader(), BorderLayout.PAGE_START);
panel.add(scrollPane, BorderLayout.CENTER);
getContentPane().add(panel);
}