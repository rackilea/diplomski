JTextField tf1 = new JTextField();
frame.add(tf1);

JButton b = new JButton();
b.setText("Solve");
b.setBounds(30, 140, 110, 30);

b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String tfone = tf1.getText();
                int one = Integer.parseInt(tfone);

                int[][] array = new int[4][5]; 
                array[0][0] = one;
                array[0][1] = otherValues...
             //Here you can complete the rest of functions