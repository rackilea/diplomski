Button otherCamera = (Button) findViewById(R.id.OtherCamera);

otherCamera.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if (inPreview) {
    camera.stopPreview();
}
//NB: if you don't release the current camera before switching, you app will crash
camera.release();

//swap the id of the camera to be used
if(currentCameraId == Camera.CameraInfo.CAMERA_FACING_BACK){
    currentCameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
}
else {
    currentCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
}
camera = Camera.open(currentCameraId);

setCameraDisplayOrientation(CameraActivity.this, currentCameraId, camera);
try {

    camera.setPreviewDisplay(previewHolder);
} catch (IOException e) {
    e.printStackTrace();
}
camera.startPreview();
}