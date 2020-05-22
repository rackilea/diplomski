public void paint(Graphics g)
{
    super.paint(g);

    if(check)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, 50, 50);
    }
}