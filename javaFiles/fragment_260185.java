public void onSurfaceChanged(GL10 gl, int width, int height) 
{
    mViewWidth = width;
    mViewHeight = height;

    gl.glViewport(0, 0, mViewWidth,  mViewHeight);
    gl.glLoadIdentity();
    GLU.gluOrtho2D(gl, 0, mViewWidth, mViewHeight, 0);
}

public void onSurfaceCreated(GL10 gl, EGLConfig config) 
{
    gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
    gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
    gl.glShadeModel(GL10.GL_FLAT);
    gl.glDisable(GL10.GL_DEPTH_TEST);
    gl.glEnable(GL10.GL_BLEND);
    gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA); 

    gl.glViewport(0, 0, mViewWidth,  mViewHeight);
    gl.glMatrixMode(GL10.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glEnable(GL10.GL_BLEND);
    gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
    gl.glShadeModel(GL10.GL_FLAT);
    gl.glEnable(GL10.GL_TEXTURE_2D);

    GLU.gluOrtho2D(gl, 0, mViewWidth, mViewHeight, 0);
}