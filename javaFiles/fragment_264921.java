public interface Shape {
    public double area(); 
}

public class Circle implements Shape{
    // constructors
    // radius
    // implement area();
}

public class Rectangle implements Shape {
    // constructors
    // height, width
    // implement area();
}

public interface Drawable {
    public void setColor(Color c);
    public void setPoistion(int x, int y);
    public void draw(Graphics g);
}

public class DrawableCirlce extends Circle implements Drawable {
    // constructors
    // implement setColor();
    // implement setPosition();
    // implement draw();
}

public class DrawableRectangle extends Rectangle implements Drawable {
    // constructors
    // implement setColor();
    // implement setPosition();
    // implement draw();
}