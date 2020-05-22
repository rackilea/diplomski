public void actionPerformed(ActionEvent arg0) {
  RunOrWalk frame = new RunOrWalk();
  double km = Double.parseDouble(textField1.getText().replace("km",""));
  //read what is in textField1, remove the "km" and transform into a double.
  km = km * 0.1;
  frame.setText(km + " $");
  frame.setVisible(true);
  dispose();
}