SpringLayout layout = new SpringLayout();

    JPanel masterPanel = new JPanel(layout);
    masterPanel.setBackground(Color.GREEN);

// 1
    JPanel leftUpper = new JPanel();
    leftUpper.setBackground(Color.MAGENTA);
    masterPanel.add(leftUpper);

// 2
    JPanel leftLower = new JPanel();
    leftLower.setBackground(Color.BLUE);
    masterPanel.add(leftLower);

// 3
    JPanel rightUpper = new JPanel();
    rightUpper.setBackground(Color.RED);
    masterPanel.add(rightUpper);

// 4
    JPanel rightLower = new JPanel();
    rightLower.setBackground(Color.CYAN);
    masterPanel.add(rightLower);

    Spring leftUpperHeight = Spring.height(leftUpper);
    Spring leftLowerHeight = Spring.scale(leftUpperHeight, 6);

    Spring rightLowerHeight = Spring.scale(leftUpperHeight, 7 / 5f);

    Spring leftWidth = Spring.width(leftUpper);
    Spring rightWidth = Spring.scale(leftWidth, 3);

    layout.getConstraints(leftLower).setHeight(leftLowerHeight);
    layout.getConstraints(rightLower).setHeight(rightLowerHeight);

    layout.getConstraints(rightUpper).setWidth(rightWidth);
    layout.getConstraints(rightLower).setWidth(rightWidth);

    // Place leftLower beneath leftUpper.
    layout.putConstraint(
        SpringLayout.NORTH, leftLower, 0,
        SpringLayout.SOUTH, leftUpper);

    // Make leftLower's width match leftUpper's width.
    layout.putConstraint(
        SpringLayout.WEST, leftLower, 0,
        SpringLayout.WEST, leftUpper);
    layout.putConstraint(
        SpringLayout.EAST, leftLower, 0,
        SpringLayout.EAST, leftUpper);

    // Make container high enough to hold both leftLower and leftUpper.
    layout.putConstraint(
        SpringLayout.SOUTH, masterPanel, 0,
        SpringLayout.SOUTH, leftLower);

    // Place rightUpper and rightLower to the right of leftUpper.
    layout.putConstraint(
        SpringLayout.WEST, rightLower, 0,
        SpringLayout.EAST, leftUpper);
    layout.putConstraint(
        SpringLayout.WEST, rightUpper, 0,
        SpringLayout.WEST, rightLower);

    // Make container wide enough to accommodate rightUpper and rightLower.
    layout.putConstraint(
        SpringLayout.EAST, masterPanel, 0,
        SpringLayout.EAST, rightLower);

    // Align bottom of rightLower with bottom of leftLower.
    layout.putConstraint(
        SpringLayout.SOUTH, rightLower, 0,
        SpringLayout.SOUTH, leftLower);

    // Place rightUpper above rightLower.
    layout.putConstraint(
        SpringLayout.SOUTH, rightUpper, 0,
        SpringLayout.NORTH, rightLower);

    // Stretch rightUpper to reach to the top of the container.
    layout.putConstraint(
        SpringLayout.NORTH, rightUpper, 0,
        SpringLayout.NORTH, masterPanel);