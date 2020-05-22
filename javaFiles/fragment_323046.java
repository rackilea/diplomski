@Override
public void paintComponent(Graphics g)
{
    super(g);
    int w = image.getWidth();
    int h = image.getHeight();
    g.drawImage(image, 0,0, w, line, 0,0,w,h,this);
}