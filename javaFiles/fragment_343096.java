double value = 0.0;
if (shape instanceof Circle) {
    Circle circle = (Circle)shape; // Cast the shape to a Circle
    value = circle.radius;
} else {
    // If it's not a circle, then it's a rectangle
    Rectangle rectangle = (Rectangle)shape; // Cast the shape to a Rectangle
    value = (double)rectangle.vertices;
}