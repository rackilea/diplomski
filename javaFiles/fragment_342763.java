private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Bitmap bMap = BitmapFactory.decodeByteArray(data, 0, data.length);
        if (currentCameraId == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            frontFacing = true;
        }
    }
};