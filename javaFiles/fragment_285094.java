public interface Shape {
    void draw();
}

public class Rectangle implements Shape {
    @Override
    public void draw() { // draw rect }
}

public class Circle implements Shape {
    @Override
    public void draw() { // draw circle }
}