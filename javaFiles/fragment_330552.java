interface Shape {
    void setPosition(int x, int y);
    void draw();
}
interface ShapeWithText : Shape {
    void setText(string text);
}
class Line implements Shape {
    // ...
}
class Circle implements Shape {
    // ...
}
class TextBox implements ShapeWithText {
    // ...
}
class CircularText implements ShapeWithText {
    // ...
}