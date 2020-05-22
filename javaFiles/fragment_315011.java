public void paintComponent(Graphics g){
  g.setColor(Color.blue);
  g.fillRect(r.x, r.y, r.width, r.height);
  g.setColor(Color.black);
  // You can play with this code to center the text
  g.drawString(text, r.x, r.y+r.height);
}