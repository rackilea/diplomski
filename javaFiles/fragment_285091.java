private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
  Double cb1,cb2,cb3,cb4,cb5,cb6;
  Double total=0d;
  if (jCheckBox1.isSelected() == true) {jCheckBox1.setText("50");}
   else jCheckBox1.setText("");
  if (jCheckBox2.isSelected() == true) {jCheckBox2.setText("50");}
   else jCheckBox2.setText("");
  if (jCheckBox3.isSelected() == true) {jCheckBox3.setText("50");}
   else jCheckBox3.setText("");
  if (jCheckBox4.isSelected() == true) {jCheckBox4.setText("50");}
   else jCheckBox4.setText("");
  if (jCheckBox5.isSelected() == true) {jCheckBox5.setText("50");}
   else jCheckBox5.setText("");
  if (jCheckBox6.isSelected() == true) {jCheckBox6.setText("50");}
   else jCheckBox6.setText("");
  cb1=Double.parseDouble((jCheckBox1.getText().equals(""))?"0":"50");
  cb2=Double.parseDouble((jCheckBox2.getText().equals(""))?"0":"50");
  cb3=Double.parseDouble((jCheckBox3.getText().equals(""))?"0":"50");
  cb4=Double.parseDouble((jCheckBox4.getText().equals(""))?"0":"50");
  cb5=Double.parseDouble((jCheckBox5.getText().equals(""))?"0":"50");
  cb6=Double.parseDouble((jCheckBox6.getText().equals(""))?"0":"50");
  total=cb1+cb2+cb3+cb4+cb5+cb6;
  jLabel1.setText("The total comes out to be :- "+total);    
}