public void draw() {
    setColor(material);
    glBegin(GL_QUADS);
        glVertex2i(SIZE*(x-1) + PADDING_HALF, SIZE*y     - PADDING_HALF); //top-left vertex
        glVertex2i(SIZE*x     - PADDING_HALF, SIZE*y     - PADDING_HALF); //top-right vertex
        glVertex2i(SIZE*(x-1) + PADDING_HALF, SIZE*(y-1) + PADDING_HALF); //bottom-left vertex
        glVertex2i(SIZE*x     - PADDING_HALF, SIZE*(y-1) + PADDING_HALF); //bottom-right vertex
    glEnd();
}