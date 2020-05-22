btnAddFiles_1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object rowData[][] = { { "01.", node, }};
        Object columnNames[] = { "Sl.no", "File name"};
        table_2.setModel(new DefaultTableModel(rowData, columnNames));
   }
});