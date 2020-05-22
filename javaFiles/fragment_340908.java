final JPanel content = new JPanel(new BorderLayout());
    content.add(chartPanel);

    final JPanel buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.add(button1, BorderLayout.NORTH);
    buttonPanel.add(button2, BorderLayout.SOUTH);

    content.add(buttonPanel, BorderLayout.SOUTH);
    setContentPane(content);