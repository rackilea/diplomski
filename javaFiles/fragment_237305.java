glBegin(GL_QUADS);
        glTexcoord2f(0, 0);
        glVertex2i(coord1, coord1);

        glTexcoord2f(0, 1);
        glVertex2i(coord1, coord2);

        glTexcoord2f(1, 1);
        glVertex2i(coord2, coord2);

        glTexcoord2f(1, 0);
        glVertex2i(coord2, coord1);
    glEnd();