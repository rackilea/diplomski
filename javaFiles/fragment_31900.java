//
//  Implement the PropertyChangeListener interface
//
    @Override
    public void propertyChange(PropertyChangeEvent e)
    {
        //  A cell has started/stopped editing

        if ("tableCellEditor".equals(e.getPropertyName()))
        {
            if (table.isEditing())
                // code for editing started;
            else
                // code for editing stopped;
        }
    }