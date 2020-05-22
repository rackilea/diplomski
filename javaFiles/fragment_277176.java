Car[] carArray = new Car[b];
private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
    // TODO add your handling code here:
    int a = 0;
    int b = 1;


    carArray[a] = new Car (txtfBrand.getText(), txtfYear.getText());
    a++;
    b++;
}                                      

private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {                                        
    // TODO add your handling code here:
    for (int i = 0; i < carArray.length; i++) {    //I get and error on this line for 'carArray'...
        txtaRead.setText(" " + carArray[i] + "\n");    //...And on this line, also for 'carArray'
    }
}