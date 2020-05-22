String[] oldValues = new String [5];
JComboBox comboBox = new JComboBox(oldValues);

public void changeChoices ( String [] newValues )
{
   comboBox.removeAllItems();

   for( int i = 0; i < newValues.length; i++ )
       comboBox.addItem( newValues [ i ] );
}