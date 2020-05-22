EglBase rootEglBase = EglBase.create(); 
SurfaceViewRenderer pipRenderer = (SurfaceViewRenderer) findViewById(R.id.pip_video_view); //You need define your UI element to render video 
pipRenderer.init(rootEglBase.getEglBaseContext(), null);
pipRenderer.setScalingType(ScalingType.SCALE_ASPECT_FIT);
localVideoTrack.setEnabled(true);
localVideoTrack.addRenderer(new VideoRenderer(pipRenderer));