ActionListener updateUserTalking = new ActionListener(){
@Override
public void actionPerformed(ActionEvent arg0) {
    JTextField tf = textField; //New message
    JTextArea ta = textArea; //Previous message to track an history
    JRadioButton jrb = (JRadioButton) arg0.getSource();
    String str = ta.getText()+"Button "+jrb.getLabel();
    str = str+tf.setText(str+System.lineSeparator());
}