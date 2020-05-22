JPanel mainPanel1 = new JPanel(new GridLayout(6,1));
    mainPanel1.add(titleLabel);
    mainPanel1.add(participantPanel);
    mainPanel1.add(swimPanel);
    mainPanel1.add(ridePanel);
    mainPanel1.add(runPanel);
    mainPanel1.add(categoriesPanel);

    JPanel mainPanel2 = new JPanel(new GridLayout(1,1));        
    mainPanel2.add(listPanel);

    JPanel mainPanel3 = new JPanel(new GridLayout(1,1));
    mainPanel3.add(buttonsPanel);

    this.getContentPane().add(mainPanel1, BorderLayout.NORTH);
    this.getContentPane().add(mainPanel2, BorderLayout.CENTER);
    this.getContentPane().add(mainPanel3, BorderLayout.SOUTH);