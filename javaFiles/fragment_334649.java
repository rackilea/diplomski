/* Setup Position Pointer */
glBindBuffer    (GL_ARRAY_BUFFER, cube);
glVertexPointer (3, GL_FLOAT, 0, 0);

/* Setup Texture Coordinate Pointer */
glBindBuffer      (GL_ARRAY_BUFFER, texture);
glTexCoordPointer (2, GL_FLOAT, 0, 0);