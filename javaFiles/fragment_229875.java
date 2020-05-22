@Overide
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);

    g.drawImage(...); // paint the background

    for (each item in the ArrayList)
    {
        Point p = item.getPoint();
        Image image = item.getImage();
        g.drawImage(...);
    }
}