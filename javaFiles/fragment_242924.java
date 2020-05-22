JButton button = new JButton("Push me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pushed me!");
            }
        });