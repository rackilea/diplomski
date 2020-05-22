gl.glLoadIdentity(); //remove the following translate that's still in the modelview matrix from the previous display() call
gl.glTranslatef(180, 15); //modifies the modelview matrix
gl.glBegin(GL_LINES); 
gl.glVertex2f(0, 0);
gl.glVertex2f(-170, 130);
gl.glEnd();