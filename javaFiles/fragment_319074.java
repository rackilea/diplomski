private CameraBridgeViewBase mOpenCvCameraView;

 @Override
 public void onCreate(Bundle savedInstanceState) {
     Log.i(TAG, "called onCreate");
     super.onCreate(savedInstanceState);
     getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
     setContentView(R.layout.HelloOpenCvLayout);
     mOpenCvCameraView = (CameraBridgeViewBase) findViewById(R.id.HelloOpenCvView);
     mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
     mOpenCvCameraView.setCvCameraViewListener(this);
 }

 @Override
 public void onPause()
 {
     super.onPause();
     if (mOpenCvCameraView != null)
         mOpenCvCameraView.disableView();
 }

 public void onDestroy() {
     super.onDestroy();
     if (mOpenCvCameraView != null)
         mOpenCvCameraView.disableView();
 }

 public void onCameraViewStarted(int width, int height) {
 }

 public void onCameraViewStopped() {
 }

 public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
     return inputFrame.rgba();
 }