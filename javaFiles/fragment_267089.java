JButton btnAddRow = new JButton(new AbstractAction("Add Row") {

    @Override
    public void actionPerformed(ActionEvent e) {
        tableModel.addRow(new Object[]{"new row"});
        int last = table.getModel().getRowCount() - 1;
        Rectangle r = table.getCellRect(last, 0, true);
        table.scrollRectToVisible(r);
    }
});