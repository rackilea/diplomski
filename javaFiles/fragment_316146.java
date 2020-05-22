public void onDrawFrame(GL10 gl) {
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);    
    gl.glMatrixMode(GL10.GL_PROJECTION);
    gl.glLoadIdentity();
    /* SET NEW PROJECTION HERE: ortho or perspective */
    gl.glOrthof(0, _width, 0, _height, 0.001f, 100); 

    gl.glMatrixMode(GL10.GL_MODELVIEW);
    gl.glLoadIdentity();
    /* SET NEW MODELVIEW MATRIX( space transformation ) HERE and DRAW YOUR STUFF */

    //change zvalues
    if(locZ >= 99.0f){
        speedZ *= -1.0f;
        locZ = 99.0f;
    }
    else if(locZ <= 1.0){
        speedZ *= -1.0f;
        locZ = 1.0f;
    }

}