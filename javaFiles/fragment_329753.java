for (CustomClass circle: circles.get)
{
    if (circle.isPainted())
    {
        g.setColor(...);
        g.fillOval(circle.getX(), circle,getY(), circle.getWidth(), circle.getHeight());
        ...
    }
}