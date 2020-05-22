public void actionPerformed(ActionEvent e) {  
        String tmp= field2.getText()  
        field2.setText(field1.getText());  

        field1.setText(tmp);  
    }