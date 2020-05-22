gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.7, 0.1, 0.7, 0.8);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(0, 50, 0);
  gl.glVertex3f(25, 0, 25);
gl.glEnd();

gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.1, 0.9, 0.7, 0.8);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(-25, 0, -25);
  gl.glVertex3f(0, 50, 0);
gl.glEnd();

gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.1, 0.1, 0.9, 0.8);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(25, 0, -25);
  gl.glVertex3f(0, 50, 0);
gl.glEnd();

gl.glBegin(GL.GL_TRIANGLES);
  gl.glColor4f(0.1, 0.9, 0.7, 0.8);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(-25, 0, 25);
  gl.glVertex3f(0, 50, 0);
gl.glEnd();