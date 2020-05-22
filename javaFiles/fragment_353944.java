List<JTextField> textFields = new ArrayList<JTextField>();

for (int i = 0; i < 10; i++)
{
    JTextField textField = new JTextField();
    textFields.add( textField );
    somePanel.add( textField );
}

somePanel.revalidate();