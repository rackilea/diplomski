class MyClass {
  final JTextField textOperand = new JTextField();

  public MyClass() {
    textOperand.setBounds(200,100,75,25);

    //textOperand action Listener
    textOperand.addActionListener( new ActionListener () {
      public void actionPerformed(ActionEvent e) {
        someOtherMethod(textOperand.getText()); 
      }
    });
  }

  public someOtherMethod(String value) {
    System.out.println(value);
  }
}