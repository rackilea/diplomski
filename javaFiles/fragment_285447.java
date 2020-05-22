interface Drawable {
  public void draw(Graphics g);
}

class DrawableSquare implements Drawable{
  public DrawableSquare(int x, int y, int width) { ... }
  public void draw(Graphics g) 
  {
    g.fillRect(x, y, width, width);
  }
}

class Screen {
  Collection<Drawable> drawables;

  public void paint(Graphics g) {
     for (Drawable dr: drawables) {
       dr.draw(g);
     }
  }
}