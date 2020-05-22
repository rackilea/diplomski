// Our matrices
private final float[] mtrxProjection = new float[16];
private final float[] mtrxView = new float[16];
private final float[] mtrxProjectionAndView = new float[16];

// Our screenresolution
float   mScreenWidth = 1280;
float   mScreenHeight = 768;

// Misc
Context mContext;
long mLastTime;
int mProgram;

CardView card1;
CardView card2;

public GLRenderer(Context c)
{
    mContext = c;
    mLastTime = System.currentTimeMillis() + 100;
}

public void onPause()
{
    /* Do stuff to pause the renderer */
}

public void onResume()
{
    /* Do stuff to resume the renderer */
    mLastTime = System.currentTimeMillis();
}

@Override
public void onDrawFrame(GL10 unused) {

    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

    // Get the current time
    long now = System.currentTimeMillis();

    // We should make sure we are valid and sane
    if (mLastTime > now) return;

    // Get the amount of time the last frame took.
    long elapsed = now - mLastTime;

    // Update our example

    // Render our example
    card1.Draw(mtrxProjectionAndView, 0);

    card2.Draw(mtrxProjectionAndView , 1);

    // Save the current time to see how long it took :).
    mLastTime = now;

}


@Override
public void onSurfaceChanged(GL10 gl, int width, int height) {

    // We need to know the current width and height.
    mScreenWidth = width;
    mScreenHeight = height;

    // Redo the Viewport, making it fullscreen.
    GLES20.glViewport(0, 0, (int)mScreenWidth, (int)mScreenHeight);

    // Clear our matrices
    for(int i=0;i<16;i++)
    {
        mtrxProjection[i] = 0.0f;
        mtrxView[i] = 0.0f;
        mtrxProjectionAndView[i] = 0.0f;
    }

    // Setup our screen width and height for normal sprite translation.
    Matrix.orthoM(mtrxProjection, 0, 0f, mScreenWidth, 0.0f, mScreenHeight, 0, 50);

    // Set the camera position (View matrix)
    Matrix.setLookAtM(mtrxView, 0, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1.0f, 0.0f);

    // Calculate the projection and view transformation
    Matrix.multiplyMM(mtrxProjectionAndView, 0, mtrxProjection, 0, mtrxView, 0);

}

@Override
public void onSurfaceCreated(GL10 gl, EGLConfig config) {

    card1 = new CardView(mContext, 0);
    card2 = new CardView(mContext, 1);
}