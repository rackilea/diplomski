public void display(GLAutoDrawable drawable)
{ 
    GL gl = drawable.getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    gl.glColor3f(0.4f, 1.0f, 0.4f);
    gl.glPushMatrix();
    gl.glTranslatef(0f, 0f, 0f);
    gl.glRotatef(90f, 0f, 0f, 1f);
    gl.glBegin(GL.GL_TRIANGLES);
    drawTriangle(gl,0,0,0,20,100,10); 
    gl.glEnd();
    gl.glPopMatrix(); 
}