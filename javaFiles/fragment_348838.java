MediaRecorder recorder = new MediaRecorder();
recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
recorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
recorder.setOutputFile(fileName);
recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

recorder.prepare();
recorder.start();