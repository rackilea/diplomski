mCameraPreview = new CameraPreview(this, recordMode);
FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview_wrapper);
FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
    FrameLayout.LayoutParams.MATCH_PARENT, 
    FrameLayout.LayoutParams.MATCH_PARENT, 
    Gravity.BOTTOM);
preview.addView(mCameraPreview, params);