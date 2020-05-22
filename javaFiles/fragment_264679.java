//Start Video Capture Thread
if (videoCaptureThread==null||videoCaptureHandler==null){
    videoCaptureThread = new HandlerThread("VideoCapture");
    videoCaptureThread.start();
    videoCaptureHandler = new Handler(videoCaptureThread.getLooper());
}

videoCaptureHandler.postDelayed(runVideoCaptureLoop, (long) 33.3333333333);