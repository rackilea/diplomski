JButton button = new JButton();
JTextField textField = new JTextField();

button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt)
    {
       //set text to whatever in array probably in for loop
       textField.setText( getArrayValues(array) );
    }
});

...

public String getArrayValues(int[] array)
{
   String value = new String();
   for(int i = 0; i < array.length-1; i++)
   {
      value += i + ", ";
   }
   value += i;
   return value;
}