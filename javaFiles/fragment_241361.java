private void DishFormPanelistIdTxtKeyTyped(java.awt.event.KeyEvent evt) {                                               
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }