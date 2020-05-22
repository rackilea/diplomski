public class MyClass
{
  JTextField myTextField = new JTextField(10);
  JButton myTextFieldSubmit = new JButton("Submit");

  public MyClass()
  {
    myTextFieldSubmit.addActionListener(new ListenerClass(this));
  }

  public static void main(String args[])
  {
    new MyClass();
  }
}

class ListenerClass implements ActionListener
{
  MyClass myClass;

  public ListenerClass(MyClass myClass)
  {
    this.myClass = myClass;
  }

  public void actionPerformed(ActionEvent e)
  {
    myClass.myTextField.setText("");
  }
}