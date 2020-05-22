provide void addTextField(JPanel form, String columnName)
{
    Jlabel label = new JLabel( columnName );
    form.add( label );
    JTextField textField = new JTextField(10);
    form.add( textField );
    textFields.put(columnName, textField);
}