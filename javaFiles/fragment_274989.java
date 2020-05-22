public class KeyPressedAction extends Action{
  JTextField tf;
  String num;
  public KeyPressedAction(JTextField textField,String num){
    this.tf = textField;
    this.num = num;
  }

  public void actionPerformed(ActionEvent e){
    textField.setText(textField.getText+num);
  }
}