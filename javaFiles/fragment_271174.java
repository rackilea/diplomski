mOpenCvCameraView = (CameraBridgeViewBase) new JavaCameraView(this, -1);
    mOpenCvCameraView.setCvCameraViewListener(this);

    mLayout.addView(mOpenCvCameraView);

    mSurfaceView.setZOrderMediaOverlay(true);
    setGLBackgroundTransparent(true);
    mRenderer = new OpenGLRenderer(this);
    mRenderer.setSurfaceView(mSurfaceView);
    super.setRenderer(mRenderer);

mRenderer.setCameraPosition(0, 0, 20);