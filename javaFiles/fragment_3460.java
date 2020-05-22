@Override
public void paint(Graphics g)
{
    ...
        b.move(getSize());
    ...
}

public void move(Dimension panelSize)
{
    if (x < 0 || x > panelSize.getWidth() - size) xVel *= -1;
    if (y < 0 || y > panelSize.getHeight - size) yVel *= -1;
    x += xVel;
    y += yVel;
}