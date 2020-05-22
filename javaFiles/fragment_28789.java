public void init() {
        targetTable = new JTable(new DefaultTableModel());
    }

    public void addRow(){
        ((DefaultTableModel)targetTable.getModel()).addRow(new Object[]{});
    }