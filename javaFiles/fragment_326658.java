private void MainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {

        if(CashierPanel.isShowing()){
            Barcode_txt.requestFocus();
        }       
    }