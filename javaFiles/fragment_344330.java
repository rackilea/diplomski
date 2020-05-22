protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // This is INCREDIBLY bad
    setBorder(BorderFactory.createLineBorder(Color.green));
    setMaximumSize(new Dimension(40, 40));
    setPreferredSize(new Dimension(40, 40));
    setSize(new Dimension(40, 40));
    //------------

    g.setColor(Color.RED);
    g.fillRect(0, 0, 40, 40);
}