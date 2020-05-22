public abstract class Shape{
    public abstract void draw(ShapeDrawer drawer, Vec3 position, float angle);
}

public class Rectangle extends Shape {
    ... other stuff ...
    public void draw(ShapeDrawer drawer, Vec3 position, float angle) {
        drawer.drawRectangle(this, position, angle);
    }
    ... other stuff ...
}

public class Circle extends Shape {
    ... other stuff ...
    public void draw(ShapeDrawer drawer, Vec3 position, float angle) {
        drawer.drawCircle(this, position, angle);
    }
    ... other stuff ...
}