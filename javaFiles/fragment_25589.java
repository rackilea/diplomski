@Override
protected void paintComponent(Graphics g){
  super.paintComponent(g);
  Graphics2D g2 = (Graphics2D) g.create();
  g2.setColor(Color.RED);
  g2.fillRect(w, h, x, y);
  g2.dispose(); // only do this if you create your own Graphics context
}