JComboBox comboBox = new JComboBox( ... )
{
    @Override
    public void setSelectedItem(Object item)
    {
        super.setSelectedItem( item );
        ComboBoxEditor editor = getEditor();
        JTextField textField = (JTextField)editor.getEditorComponent();
        textField.setCaretPosition(0);
    }
};