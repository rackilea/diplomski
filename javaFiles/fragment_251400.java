// jt is a JTable defined at class level for handle visibility
jt = new JTable() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        super.valueChanged(e);
        if(e.getValueIsAdjusting()) return;

        if(jt.getSelectedRow() == 1 && jt.getSelectedRows().length == 1) {
            ListSelectionModel lsm = jt.getSelectionModel();
            lsm.addSelectionInterval(3, 3);
            lsm.addSelectionInterval(5, 5);
        }
    }
};