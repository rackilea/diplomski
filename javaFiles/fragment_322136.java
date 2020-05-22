slider_2.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
         /* 
         here you did wrong...
         textField.setText(String.valueOf(slider_2.getValue()));
         */
        textField_1.setText(String.valueOf(slider_2.getValue()));
        }
    });