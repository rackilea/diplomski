final float x = shape.vertices[0].x;
final float y = shape.vertices[0].y;
final int rightEdge = x + shape.width;
if ((x >= fromX && x <= toX) || // left side of shape in screen
(x <= fromX && rightEdge >= fromX) || // right side of shape in screen
(x >= fromX && rightEdge <= toX)) { // shape fully in screen

    // ...
}