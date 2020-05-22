protected void paintComponent(Graphics g) { 
    int h = getHeight();
    int w = getWidth();
    super.paintComponent(g); 
    g.setColor(CHECKER_COLOR);
    g.fillOval(w/2, h/2, w, h); 
}