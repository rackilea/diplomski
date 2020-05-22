private void addCustomerToTable(Customer customer) {
    DefaultTableModel model = (DefaultTableModel) accountTable.getModel();
    model.setRowCount(model.getRowCount() + 1);
    model.addRow(new Object[] {
        customer.getFirstName(),
            customer.getLastName(), customer.getAccount().getAccountNumber(),
            customer.getAccount().getBalance()
    });
}