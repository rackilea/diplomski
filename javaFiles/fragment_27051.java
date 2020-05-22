btnAddFiles_1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object rowData[][] = { { "01.", node, }};
        Object columnNames[] = { "Sl.no", "File name"};
        JTable table = new JTable(rowData, columnNames); // new JTable that is not placed in the content pane
   }
});