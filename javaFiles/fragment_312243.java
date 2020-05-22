btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            String text1 = textField.getText();
            String text2 = textField_1.getText();
            textField_2.setText(getIntegerValue(text1) + getIntegerValue(text2) + "");
        }
    });