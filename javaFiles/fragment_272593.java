public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
     super.onCaptureCompleted(session, request, result);
     Toast.makeText(MainActivity.this, "Saved "+file, Toast.LENGTH_SHORT).show();

     Log.d(TAG, String.valueOf(result.get(CaptureResult.SENSOR_EXPOSURE_TIME)));

     createCameraPreview();
}