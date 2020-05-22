protected void paintComponent(Graphics g) {
  int R = (int)(Math.random()*256);
  int G = (int)(Math.random()*256);
  int B = (int)(Math.random()*256);
  Color color = new Color(R, G, B); // picks a random color
  g.setColor(color);

  int ovalA = (int)(Math.random()*400);
  int ovalB = (int)(Math.random()*300);
  int ovalC = (int)(Math.random()*(400 - ovalA));
  int ovalD = (int)(Math.random()*(300 - ovalB));
  g.fillOval(ovalA, ovalB, ovalC, ovalD);


  R = (int)(Math.random()*256);
  G = (int)(Math.random()*256);
  B = (int)(Math.random()*256);
  color = new Color(R, G, B); // picks a random color

  int rectA = (int)(Math.random()*300);
  int rectB = (int)(Math.random()*400);
  int rectC = (int)(Math.random()*(400 - rectA));
  int rectD = (int)(Math.random()*(300 - rectB));
  super.paintComponent(g);
  g.setColor(color);
  g.fillRect(rectA, rectB, rectC, rectD);
}