public class RajawaliActivity extends Activity {
protected GLSurfaceView mSurfaceView;
protected FrameLayout mLayout;
protected boolean mUsesCoverageAa;
private RajawaliRenderer mRajRenderer;
protected boolean checkOpenGLVersion = true;
protected boolean mDeferGLSurfaceViewCreation = false;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if(!mDeferGLSurfaceViewCreation)
        createSurfaceView();
}

protected void createSurfaceView()
{
    mSurfaceView = new GLSurfaceView(this);

    ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);

    mSurfaceView.setEGLContextClientVersion(2);

    mLayout = new FrameLayout(this);
    mLayout.addView(mSurfaceView);


    setContentView(mLayout);
}