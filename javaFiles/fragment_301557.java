calculate.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int i1 = Integer.valueOf(jtf1.getText());
                int i2 = Integer.valueOf(jtf2.getText());
                System.out.println("sum=" + (i1 + i2));
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    });