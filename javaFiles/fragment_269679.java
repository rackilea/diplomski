for (int i = shapes.size() - 1; i >= 0; i--) { // check shapes from
                                                        // front to back
    Shape s = (Shape) shapes.get(i);
    if (s.containsPoint(x, y)) {
         dragShape = s;
         prevDragX = x;
         prevDragY = y;
         clickShape = s;
         break;
    }
}