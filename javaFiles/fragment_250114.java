private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {    
            if(checkBox.isSelected() ){
                   total=8.99f;
                   xc = "XCheese";
                   exTop++;
                   calculateTotal(total);
                   updateTextArea();
            }else{
                   // set everything zero here.
            }

}