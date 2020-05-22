JPanel outer = new JPanel(new GridBagLayout()); 
    JPanel drawPanel = new JPanel(new GridBagLayout());
    drawPanel.add(new DrawingBoard(500,500));
    drawPanel.setBackground(Color.WHITE);
    outer.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
    JScrollPane scrollPane = new JScrollPane(drawPanel);
    outer.add(scrollPane);
    this.add(outer, BorderLayout.CENTER);