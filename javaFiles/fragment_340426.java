jb1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtf1.setText(String.valueOf(Integer.valueOf(jtf1.getText())-1));
        }
    });

    jb2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            jtf1.setText(String.valueOf(Integer.valueOf(jtf1.getText())+1));
        }
    });