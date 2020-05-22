JPanel leftPanel = new JPanel(new BorderLayout());

// 1
    JPanel leftUpper = new JPanel();
    leftUpper.setBackground(Color.MAGENTA);
    leftUpper.setPreferredSize(new Dimension(1, height/7));
    leftPanel.add(leftUpper, BorderLayout.NORTH);

// 2
    JPanel leftLower = new JPanel();
    leftLower.setBackground(Color.BLUE);
    leftPanel.add(leftLower, BorderLayout.CENTER);