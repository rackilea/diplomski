@Override
public void display(GLAutoDrawable drawable) {
    // TODO Auto-generated method stub
     GL2 gl = drawable.getGL().getGL2();
     gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);             
     gl.glMatrixMode(GL2.GL_MODELVIEW);
     gl.glLoadIdentity();
     // call your draw code here

        gl.glTranslatef(0, 0, xLoc);
        gl.glRotatef(rotateX, 1, 0, 0);
        gl.glRotatef(rotateY, 0, 1, 0);
        gl.glRotatef(rotateZ, 0, 0, 1);

        square.draw(gl);

     // end calls for drawing 

}