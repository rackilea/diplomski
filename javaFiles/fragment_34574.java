public void paintComponent(Graphics g){
     super.paintComponent(g);//this is very important
      Graphics2D g2 = (Graphics2D) g;
      ....
      Ellipse2D circle = new Ellipse.Double(0,0,panelWidth,panelHeight);
      g2.draw(circle);  
}