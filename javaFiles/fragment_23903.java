final JPanel north = new JPanel(new FlowLayout());
    north.add(mpgEnter);
    north.add(gasPriceEnter);
    north.add(distanceEnter);
    // add button
    btnEnter = new Button("Enter");
    btnEnter.addActionListener(this);
    north.add(btnEnter);
    // add label
    add(north, BorderLayout.NORTH);
    // setResizable(false);
    lblResult = new Label("");
    lblResult.setPreferredSize(new Dimension(200, 20));
    add(lblResult, BorderLayout.CENTER);