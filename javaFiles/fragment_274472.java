private int money = 0;
    ...
    JButton verlan = new JButton("50 kr\u015F");
    verlan.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
        money += 50;
        String x=Integer.toString(money);
        textArea.setText(x + " cent");

        }
    });