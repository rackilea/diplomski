try{
    camera = android.hardware.Camera.open();
}
catch (RuntimeException e){
    System.err.println(e);
    return;
}

List<Camera.Size> picSizes;
android.hardware.Camera.Size largestSize;
android.hardware.Camera.Parameters param;
param = camera.getParameters();
param.setPreviewSize(352, 288);
param.setFlashMode(FLASH_MODE_AUTO);
param.setFocusMode(FOCUS_MODE_AUTO);     
param.setPictureSize(1952,1952);
param.setJpegQuality(100);
param.setExposureCompensation(param.getMinExposureCompensation());
param.setWhiteBalance(WHITE_BALANCE_AUTO);
camera.setParameters(param);

try {
    camera.setPreviewDisplay(surfaceHolder);
    camera.startPreview();
}

catch (Exception e) {
    System.err.println(e);
}