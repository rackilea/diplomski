private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
   double AText = ParseDouble(angleAField.getText());
   double BText = ParseDouble(angleBField.getText());
   double CText = ParseDouble(angleCField.getText());
   double aText = ParseDouble(sideaField.getText());
   double bText = ParseDouble(sidebField.getText());
   double cText = ParseDouble(sidecField.getText());

// other code here same
}

double ParseDouble(String strNumber) {
   if (strNumber != null && strNumber.length() > 0) {
       try {
          return Double.parseDouble(strNumber);
       } catch(Exception e) {
          return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
       }
   }
   else return 0;
}