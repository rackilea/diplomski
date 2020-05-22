public class MyClass
{
  final static JTextField myTextField = new JTextField(10);
  final static JButton myTextFieldSubmit = new JButton("Submit");

  public static void main(String args[])
  {
    myTextFieldSubmit.addActionListener(new ListenerClass());
  }

  static class ListenerClass implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      myTextField.setText("");
    }
  }
}