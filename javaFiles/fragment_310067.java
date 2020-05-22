JFrame f = new JFrame();
JPanel p = new JPanel () {
     public void paint(Graphics g){
         Graphics2D g2d = printImg.createGraphics();
         g2d.drawString("123", 10, 10);        
     }
 }
 f.add(p);
 f.setSize(100,100);
 f.setVisible(true);