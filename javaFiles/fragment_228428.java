private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      searchtext = jsearchText.getText();
      File f = new File(searchtext);
    if(f.exists() && f.isFile()) {
        jLabel3.setText("found : "+searchtext);
    } else {
        jLabel3.setText("not found : "+searchtext);
    }
    }