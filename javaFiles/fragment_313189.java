@Override

 public void surfaceCreated(SurfaceHolder holder) {

    try {
        camera.setPreviewDisplay(holder);
    } catch (Exception e) {

        e.printStackTrace();
    }
}
camera is
camera=Camera.open();