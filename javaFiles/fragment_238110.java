@Override
public void paint(Graphics g) {

    int x = 50;
    int y = 50;

    super.paint(g);
    g.drawLine(x-2, y-2, x+2, y+2); 
    g.drawLine(x-2, y+2, x+2, y-2);
}