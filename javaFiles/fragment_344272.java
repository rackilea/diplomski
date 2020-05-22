private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
    int n = Integer.parseInt(objectsChooseField.getText());
    int r = Integer.parseInt(chooseFromField.getText());
    int result = faculty( n ) / ( faculty( r ) * ( n - r ));
    //--- Output result to somewhere
}