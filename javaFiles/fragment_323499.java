private void tryAutoFocus() {
    if( MyDebug.LOG )
        Log.d(TAG, "tryAutoFocus");
    if( camera == null ) {
        if( MyDebug.LOG )
            Log.d(TAG, "no camera");
    }
    else if( !this.has_surface ) {
        if( MyDebug.LOG )
            Log.d(TAG, "preview surface not yet available");
    }
    else if( !this.is_preview_started ) {
        if( MyDebug.LOG )
            Log.d(TAG, "preview not yet started");
    }
    else if( is_taking_photo ) {
        if( MyDebug.LOG )
            Log.d(TAG, "currently taking a photo");
    }
    else {
        // if a focus area is set, we always call autofocus even if it isn't supported, so we get the focus box
        // otherwise, it's only worth doing it when autofocus has an effect (i.e., auto or macro mode)
        Camera.Parameters parameters = camera.getParameters();
        String focus_mode = parameters.getFocusMode();
        if( has_focus_area || focus_mode.equals(Camera.Parameters.FOCUS_MODE_AUTO) || focus_mode.equals(Camera.Parameters.FOCUS_MODE_MACRO) ) {
            if( MyDebug.LOG )
                Log.d(TAG, "try to start autofocus");
            Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() {
                @Override
                public void onAutoFocus(boolean success, Camera camera) {
                    if( MyDebug.LOG )
                        Log.d(TAG, "autofocus complete: " + success);
                    focus_success = success ? FOCUS_SUCCESS : FOCUS_FAILED;
                    focus_complete_time = System.currentTimeMillis();
                    if(_automationStarted){
                        takeSnapPhoto();
                    }
                }
            };
            this.focus_success = FOCUS_WAITING;
            this.focus_complete_time = -1;
            camera.autoFocus(autoFocusCallback);
        }
    }
}

public void surfaceCreated(SurfaceHolder holder) {
    if( MyDebug.LOG )
        Log.d(TAG, "surfaceCreated()");
    // The Surface has been created, acquire the camera and tell it where to draw.
    this.has_surface = true;
    this.openCamera(false); // if setting up for the first time, we wait until the surfaceChanged call to start the preview
    this.setWillNotDraw(false); // see http://stackoverflow.com/questions/2687015/extended-surfaceviews-ondraw-method-never-called
}
public void surfaceDestroyed(SurfaceHolder holder) {
    if( MyDebug.LOG )
        Log.d(TAG, "surfaceDestroyed()");
    // Surface will be destroyed when we return, so stop the preview.
    // Because the CameraDevice object is not a shared resource, it's very
    // important to release it when the activity is paused.
    this.has_surface = false;
    this.closeCamera();
}
public void takeSnapPhoto() {
    camera.setOneShotPreviewCallback(new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
            Camera.Parameters parameters = camera.getParameters();
            int format = parameters.getPreviewFormat();
            //YUV formats require more conversion
            if (format == ImageFormat.NV21 || format == ImageFormat.YUY2 || format == ImageFormat.NV16) {
                int w = parameters.getPreviewSize().width;
                int h = parameters.getPreviewSize().height;
                // Get the YuV image
                YuvImage yuv_image = new YuvImage(data, format, w, h, null);
                // Convert YuV to Jpeg
                Rect rect = new Rect(0, 0, w, h);
                ByteArrayOutputStream output_stream = new ByteArrayOutputStream();
                yuv_image.compressToJpeg(rect, 100, output_stream);
                byte[] byt = output_stream.toByteArray();
                FileOutputStream outStream = null;
                try {
                    // Write to SD Card
                    File file = createFileInSDCard(FOLDER_PATH, "Image_"+System.currentTimeMillis()+".jpg");
                    //Uri uriSavedImage = Uri.fromFile(file);
                    outStream = new FileOutputStream(file);
                    outStream.write(byt);
                    outStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    });
}