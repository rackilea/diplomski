protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    //create rectangle
    square = new Rectangle(100, 100, 100, 100);
    g2.draw(square);

    //create ellipse
    ellipse = new Ellipse2D.Double(5, 10, 100, 150);
    g2.draw(ellipse);
}