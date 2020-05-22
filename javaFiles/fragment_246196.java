public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;
    super.paintComponent(g2);
    g2.setColor(Color.white);
    g2.drawString("Score: ", 20, 400);

}