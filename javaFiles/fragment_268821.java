// initialColors is the list holding the initial colors
for (int i=0; i<images.size(); i++) {
    if (images.get(i).getShape() == "Rectangle") {
        if (/*code to check if we are inside the rectangle which you already have*/) {
            images.get(i).setColor(Color.BLUE);
            repaint();
        } else {
            images.get(i).setColor(initialColors.get(i));
            repaint();
        }
    } /* maybe add a case for getShape() == "Circle" */
}