public void onSurfaceChanged(GL10 gl, int width, int height) {      
    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL10.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glOrthof(0f, 320, 0f, 320*aspect, -1f, 1f);
}