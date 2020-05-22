JPanel masterPanel = new JPanel(new BorderLayout());
    masterPanel.setBackground(Color.GREEN);

    leftPanel.setPreferredSize(new Dimension(width / 3,
        leftPanel.getPreferredSize().height));

    masterPanel.add(leftPanel, BorderLayout.WEST);
    masterPanel.add(rightPanel, BorderLayout.CENTER);