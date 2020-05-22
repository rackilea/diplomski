@Override
public void onDrawFrame(GL10 gl) {
    // TODO Auto-generated method stub


    gl.glDisable(GL10.GL_DITHER);
     gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);   

     gl.glMatrixMode(GL10.GL_MODELVIEW);
     gl.glLoadIdentity();
     gl.glClientActiveTexture(DRAWING_CACHE_QUALITY_HIGH);

     //Draw cube 1
     gl.glPushMatrix();
     gl.glTranslatef(-0.5f, 0, -3.0f);
     gl.glRotatef(mAngleX, 0, 1, 0);
     gl.glRotatef(mAngleY, 1, 0, 0);
     mCube.draw(gl);
     gl.glPopMatrix();

     //Draw cube 2
     gl.glPushMatrix();
     gl.glTranslatef(0, 0, -3.0f); 
     gl.glRotatef(mAngleX, 0, 1, 0);
     gl.glRotatef(mAngleY, 1, 0, 0);
     mCube.draw(gl);
     gl.glPopMatrix();

     //Draw cube 3
     gl.glPushMatrix();
     gl.glTranslatef(0.5f, 0, -3.0f); 
     gl.glRotatef(mAngleX, 0, 1, 0);
     gl.glRotatef(mAngleY, 1, 0, 0);
     mCube.draw(gl);
     gl.glPopMatrix();

}