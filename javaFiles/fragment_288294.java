//we want to modify the projection matrix (without this, mesh normals will break)
gl.glMatrixMode(GL_PROJECTION);

//clear any previous transforms the projection matrix may contain (otherwise it would be combined with the following glOrtho matrix)
gl.glLoadIdentity();

//set the projection (could use glTranslate/glScale but this utility function is simpler)
gl.glOrtho(0, width, 0, height, -1, 1); //left,right,bottom,top,front,back

//common practice to leave modelview as the current matrix for editing
gl.glMatrixMode(GL_MODELVIEW);