JPanel rightPanel = new JPanel(new BorderLayout());

// 3
    JPanel rightUpper = new JPanel();
    rightUpper.setBackground(Color.RED);
    rightPanel.add(rightUpper, BorderLayout.CENTER);


// 4
    JPanel rightLower = new JPanel();
    rightLower.setBackground(Color.CYAN);
    rightLower.setPreferredSize(new Dimension(1, height/5));
    rightPanel.add(rightLower, BorderLayout.SOUTH);