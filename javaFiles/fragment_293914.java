JPanel buttonPane = new JPanel();

    JButton button = new JButton("Home");
    JButton button2 = new JButton("Confirm");

    buttonPane.add(Box.createRigidArea(new Dimension(250,0)));

    buttonPane.add(button);
    buttonPane.add(button2);

    getContentPane().add(buttonPane, BorderLayout.SOUTH);