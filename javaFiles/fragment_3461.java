public void move(Dimension panelSize)
{
    x += xVel;
    y += yVel;
    if (x < 0) {
        x *= -1;
        xVel *= -1;
    } else if (x > panelSize.getWidth() - size) {
        x -= 2 * (x - panelSize.getWidth() - size);
        xVel *= -1;
    }
    if (y < 0) {
        y *= -1;
        yVel *= -1;
    } else if (y > panelSize.getHeight() - size) {
        y -= 2 * (y - panelSize.getHeight() - size);
        yVel *= -1;
    }
}