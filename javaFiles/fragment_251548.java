public void onCameraViewStarted(int width, int height) {
cany= new Mat(height, width, CvType.CV_8UC4);
}

public void onCameraViewStopped() {
    cany.release();
}