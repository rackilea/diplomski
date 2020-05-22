class CircleList
{
  static class Circle
  {
    public float x, y, diameter;
  }

  ArrayList<Circle> circles;

  public CirclesList()
  {
    circles = new ArrayList<Circle>();
  }

  public void draw(Graphics2D g) // draw must be called by paintComponent of the panel
  {
    for (Circle c : circles)
      g.fillOval(c.x, c.y, c.diameter, c.diameter)
  }
}