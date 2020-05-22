public MyGLSurfaceView(Context context) 
{
    super(context);
    setEGLContextClientVersion(2);
    setRenderer (new MyRenderer());
    setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
}