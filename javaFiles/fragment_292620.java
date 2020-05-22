@override
public void paintComponent(Graphics g){
    super.paintComponent(g)
    Rectangle r = new Rectangle(xPos,yPos,width,height);
    g.fillRect(r.getX(), r.getY(), r.getWidth(), r.getHeight());  
}