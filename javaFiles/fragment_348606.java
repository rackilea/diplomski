//In the JTable class    
    @Override
    public void editingStopped(ChangeEvent e) 
    {
        //getting these values before calling super.editingStopped(e); because they get erased.
        int row = getEditingRow();
        int col = getEditingColumn();
        super.editingStopped(e); //must call the super code to have a working edition
        if (row == getRowCount() - 1 && col == getColumnCount() - 1)
        {
            getModel().createNewRow();
        }
    };