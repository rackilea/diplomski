public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D G2D = (Graphics2D)g;
    G2D.setColor(Color.PINK);
    G2D.fillRect(0, 0, 800, 600);
}