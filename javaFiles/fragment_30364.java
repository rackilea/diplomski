JButton northButton = new JButton("north");
    JButton southButton = new JButton("south");
    JButton westButton = new JButton("west");
    JButton eastButton = new JButton("east");
    JButton upButton = new JButton("up");
    JButton downButton = new JButton("down");

    JPanel directionButtonPanel = new JPanel();
    directionButtonPanel.setLayout(new GridLayout(3,4));

    // row 1
    directionButtonPanel.add(new JPanel());
    directionButtonPanel.add(northButton);
    directionButtonPanel.add(new JPanel());
    directionButtonPanel.add(upButton);

    // row 2
    directionButtonPanel.add(westButton);
    directionButtonPanel.add(new JPanel());
    directionButtonPanel.add(eastButton);
    directionButtonPanel.add(new JPanel());

    // row 3
    directionButtonPanel.add(new JPanel());
    directionButtonPanel.add(southButton);
    directionButtonPanel.add(new JPanel());
    directionButtonPanel.add(downButton);