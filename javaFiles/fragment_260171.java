@Override
protected void paintChildren(Graphics g)
{
    for (int i = 0; i < relationships.size(); i += 2)
    {
        Component one = relationships.get(i);
        Component two = relationships.get(i + 1);
        Point p1 = //calculate the center of component one
        Point p2 = //calculate the center of component two
        g.drawline(p1.x, p1.y, p2.x, p2.y);
    }

    super.paintChildren(g);
}