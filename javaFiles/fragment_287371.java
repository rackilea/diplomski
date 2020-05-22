public void paintComponent(Graphics g){
    super.paintComponent(g);
    int x = getWidth() - 50;
    int y = getHeight() - 50;
    g.fillRect(x, y, 100, 100);
}