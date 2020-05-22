gamePanel = new JPanel() {
   @Override
   public void paint(Graphics g) {
       this.paint(g);

       Graphics2D g2d = (Graphics2D)g;
       g2d.drawImage(bg,0,0,null);
       g2d.drawImage(myCar.getImg(), myCar.xPos, myCar.yPos, null);

       g2d.dispose();
   }
};