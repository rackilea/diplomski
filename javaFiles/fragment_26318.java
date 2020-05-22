JButton delete = new JButton("Delete");
delete.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<User> users = new ArrayList<>(selectedRows.length);
        for (int row = 0; row < table.getRowCount(); row++) {
            int modelRow = table.convertRowIndexToModel(row);
            Boolean selected = (Boolean) model.getValueAt(modelRow, 1);
            if (selected) {
                users.add(model.getUser(modelRow));
            }
        }
        if (users.size() > 0) {
            new DeleteUserWorker(users, model).execute();
        }            
    }
});