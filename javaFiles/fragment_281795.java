btnReadString.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    String stringParameter = stringTextField.getText();
    textPane.setText(stringParameter);
  }
});