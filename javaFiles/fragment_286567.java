double ellipseX = 30;
double ellipseY = 30;
int ellipse1X = MouseInfo.getPointerInfo().getLocation().x;
int ellipse1Y = MouseInfo.getPointerInfo().getLocation().y;
//m=(y2-y1)/(x2-x1)
double slopex = (double)ellipse1X/ellipseX;
double slopey = (double)ellipse1Y/ellipseY;
public void paintComponent(Graphics g){
    g.fillOval((int)ellipseX, (int)ellipseY, 4, 4);
    ellipseX+=slopex;
    ellipseY+=slopey;
    repaint();
}