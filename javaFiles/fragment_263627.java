public class MyClass
{
  public static void main(String args[])
  {
    final JTextField myTextField = new JTextField(10);
    final JButton myTextFieldSubmit = new JButton("Submit");

    class ListenerClass implements ActionListener
    {
      public void actionPerformed(ActionEvent e)
      {
        myTextField.setText("");
      }
    }

    myTextFieldSubmit.addActionListener(new ListenerClass());
  }
}