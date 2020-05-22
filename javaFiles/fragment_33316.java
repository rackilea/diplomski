loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = username_field.getText();
            HelloWorldSwing.this.print();
        }
    });