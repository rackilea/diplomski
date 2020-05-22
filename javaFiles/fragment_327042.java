recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
    recorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);

    recorder.setPReviewDisplay(surfaceView.getHolder().getSurface())