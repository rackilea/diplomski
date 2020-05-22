public void onClick(View v) {
    if (cameraObj == null) {
        return;
    }
    Camera.Parameters cameraParams = cameraObj.getParameters();
    if (cameraParams.getFlashMode() == null) {
        return;
    }
    cameraParams.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
    cameraObj.setParameters(cameraParams);
    cameraObj.startPreview();
}