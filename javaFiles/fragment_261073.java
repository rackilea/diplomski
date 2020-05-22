public void startRecording (){
     recorder = new MediaRecorder();
     recorder.reset();      
     recorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
     recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
     recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
     if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
     {
         externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
         externalOutputPath = externalStoragePath + File.separator + "/Android/data/com.whizzappseasyvoicenotepad/test.mp3";
         recorder.setOutputFile(externalOutputPath);
     }
     else
     {
        storagePath = Environment.getDataDirectory().getAbsolutePath();
        recorder.setOutputFile(storagePath + "/Android/data/com.whizzappseasyvoicenotepad/test.mp3");
     }
     recorder.setOnErrorListener(errorListener);
     recorder.setOnInfoListener(infoListener);

     try {
        recorder.prepare();
        recorder.start();
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}