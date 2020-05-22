public void paint(Graphics g){
  //Create Graphics2D object:
  Graphics2D g2d = (Graphics2D) g.create();

  //Create rectangle of origin (0,0), w=30, h=50
  Rectangle rectangle = new Rectangle();
  rectangle.setBounds(0,0,30,50);

  //Rotate rectangle by 1 radian(Math.PI) from the bottom corner
  g2d.rotate(Math.PI, rectangle.x + rectangle.width/2, rectangle.y + rectangle.height/2);

  //Draw rectangle
  g2d.draw(rectangle);
}