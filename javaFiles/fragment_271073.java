class MyClass {
  final JTextField textOperand = new JTextField();
  public String textOperandValue;

  private class MyActionListener implements ActionListener {
    String value;

    public void actionPerformed(ActionEvent e) {
      value =textOperand.getText(); 
    }
  }

  MyActionListener l = new MyActionListener();

  public MyClass() {
    textOperand.setBounds(200,100,75,25);

    //textOperand action Listener
    textOperand.addActionListener(l);
  }

  public someOtherMethod() {
    if (l.value != null) 
      //is set
  }
}