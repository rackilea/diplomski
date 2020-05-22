@Override
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   if (indicator == 0) {
       g.drawOval(30, 40, 30, 30);
       g.drawOval(30, 70, 30, 30);
       g.drawOval(30, 100, 30, 30);
   }
}