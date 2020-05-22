private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

  SideDish = "";
  if (jCheckBox1.getState()))
  {
    SideDish += jCheckBox1.getText();
  }
  ...
  if (jCheckBox5.getState()))
  {
    SideDish += ", " + jCheckBox5.getText();
  }

  JOptionPane.showMessageDialog(rootPane, "You have chosen:\n" + Meal + "\n" + SideDish);
}