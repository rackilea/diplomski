gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.1, 0.9, 0.7, 0.8);
  gl.glVertex3f(-25, 0, 0);    // lower left vertex
  gl.glVertex3f( 25, 0, 0);    // lower right vertex
  gl.glVertex3f( 0,  50, 0);    // upper vertex
gl.glEnd();

gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.9, 0.1, 0.7, 0.8);
  gl.glVertex3f(0, 0, 25);    // lower left vertex
  gl.glVertex3f( 0, 0, -25);    // lower right vertex
  gl.glVertex3f( 0,  50, 0);    // upper vertex
gl.glEnd();