@Override  // this is in a JPanel extended class
protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   if (backgroundImg != null) {
      g.drawImage(backgroundImg, 0, 0, null);
   }
   if (spriteImg != null) {
      g.drawImage(spriteImg, spriteX, spriteY, null);
   }
}