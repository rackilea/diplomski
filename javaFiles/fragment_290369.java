button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        for(int row = 0; row < table.getRowCount(); ++row) {
            if((Boolean) table.getValueAt(row, 3) == true) {    
                ((DefaultTableModel) model).removeRow(table.convertRowIndexToModel(row));
                row--;
            }
        }
    }
});