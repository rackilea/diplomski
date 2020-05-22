class PasswordEditor extends DefaultCellEditor 
{

    TextBox m_passWord = new TextBox(); 
    public PasswordEditor() {
        super(new TextBox());
    }

            @Override
    public boolean stopCellEditing()
    {
        if(getCellEditorValue().toString().length() < 8)
        {
            JOptionPane.showMessageDialog(UsmUserView.this.m_Parent, "Password Must Be 8 Bytes Long !! Please Check");
            return false;
        }
        fireEditingStopped();
        return true;
    }

    @Override
    public Object getCellEditorValue() {

        return this.m_passWord.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {

        Object fieldValue = value;
        if(null == fieldValue)
            fieldValue = Constants.EMPTY_STRING;

        this.m_passWord.setEditable(true);
        this.m_passWord.setText(fieldValue.toString());
        return this.m_passWord;
    }


}