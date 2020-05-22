gl.glMatrixMode(GL.GL_PROJECTION); //reset the projection matrix
gl.glLoadIdentity();
gl.glOrtho(left, right, bottom, top, near, far);//change to orthographic projection
gl.glMatrixMode(GL.GL_MODELVIEW);// reset the modelview matrix
gl.glLoadIdentity();
gl.glDisable(GL.GL_DEPTH_TEST);//disable depth test
//draw 2D stuff here