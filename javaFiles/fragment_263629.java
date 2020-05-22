public class MyClass
{
  static JTextField myTextField = new JTextField(10);
  static JButton myTextFieldSubmit = new JButton("Submit");

  public static void main(String args[])
  {
    myTextFieldSubmit.addActionListener(new ListenerClass());
  }
}

class ListenerClass implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    MyClass.myTextField.setText("");
  }
}