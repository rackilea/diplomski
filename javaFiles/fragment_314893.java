private boolean inputFieldsDisplayed; 
    public void actionPerformed(ActionEvent actionEvent) {
        if( actionEvent.getSource() == button && !inputFieldsDisplayed){
            showInputFields();
            inputFieldsDisplayed = true;

        } else if ( actionEvent.getSource() == button2){                
            String me = textfield.getText();
            int computation = Integer.parseInt(me);
            computation = computation*2;
            String changecomputation = Integer.toString(computation);
            textfield2.setText(changecomputation);                
        }
        validate();
        repaint();            
    }