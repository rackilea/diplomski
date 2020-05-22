private void setFlashLightOn() {
    if (camera == null) {
        // make isCameraFlash a class level variable
        if(!isCameraFlash) {
            showNoCameraAlert();
        } else {
            camera = Camera.open();
            params = camera.getParameters();
        }
    }

    params = camera.getParameters();
    // etc