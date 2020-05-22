private VideoCapturer createCameraCapturer(CameraEnumerator enumerator) {
   final String[] deviceNames = enumerator.getDeviceNames();
   // First, try to find front facing camera
   Log.d(TAG, "Looking for front facing cameras.");
   for (String deviceName : deviceNames) {
     if (enumerator.isFrontFacing(deviceName)) {
       Log.d(TAG, "Creating front facing camera capturer.");
       VideoCapturer videoCapturer = enumerator.createCapturer(deviceName, null);
       if (videoCapturer != null) {
         return videoCapturer;
       }
     }
   }
   // Front facing camera not found, try something else
   Log.d(TAG, "Looking for other cameras.");
   for (String deviceName : deviceNames) {
     if (!enumerator.isFrontFacing(deviceName)) {
       Log.d(TAG, "Creating other camera capturer.");
       VideoCapturer videoCapturer = enumerator.createCapturer(deviceName, null);
       if (videoCapturer != null) {
         return videoCapturer;
       }
     }
   }
   return null;
 }

 VideoCapturer videoCapturer = createCameraCapturer(new Camera1Enumerator(captureToTexture()));
 VideoSource videoSource = factory.createVideoSource(videoCapturer);
 videoCapturer.startCapture(1200/*width*/, 720/*height*/, 25/*fps*/);

VideoTrack localVideoTrack = factory.createVideoTrack("NameYourTrack", videoSource);