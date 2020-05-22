JRadioButton user1 = new JRadioButton("User_1");
user1.setActionCommand("User_1");

ActionListener updateUserTalking = new ActionListener(){
@Override
public void actionPerformed(ActionEvent arg0) {
    JTextField tf = textField; //New message
    JTextArea ta = textArea; //Previous message to track an history
    String cmd = arg0.getActionCommand();
    String str = ta.getText()+"Button "+cmd;
    str = str+tf.setText(str+System.lineSeparator());
}