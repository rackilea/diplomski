private class TextFieldListener implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
     String sms = jtf.getText().trim();
     out.println("line " + sms);
  }
}