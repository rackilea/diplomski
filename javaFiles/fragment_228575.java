public void paint(Graphics g) {
   super.paint(g);  // *************** missing ************
   g.setColor(currentColor);
   if (myX > drawPanel.getX() + 10 && myY > drawPanel.getY() + 25)
      g.fillOval(myX - radius, myY - radius, 2 * radius, 2 * radius);
}