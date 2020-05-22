class MyClass {
  final JTextField textOperand = new JTextField();
  public String textOperandValue;

  public MyClass() {
    textOperand.setBounds(200,100,75,25);

    //textOperand action Listener
    textOperand.addActionListener( new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        textOperandValue = textOperand.getText();   
      }
    });
  }

  public someOtherMethod() {
    // textOperandValue available here
    if (textOperandValue != null) 
      //is set
  }
}