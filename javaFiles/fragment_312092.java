public void RecordButton (View view) {
    if(mRecorder == null){
        audioFilePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                    + "/myaudio.3gp";
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(audioFilePath);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);    
    }
    if (isRecording) {
        try{
            stopRecording();
            isRecording = false;
            ((Button)view).setText("start");
        }catch(Exception e){
           e.printStackTrace();
        }
    } else {
        try{
            startRecording();
            isRecording = true;
            ((Button)view).setText("stop");
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}

public void startRecording() throws IllegalStateException, IOException{
    mRecorder.prepare();
    mRecorder.start();
}
public void stopRecording() throws IllegalStateException, IOException{
    mRecorder.stop();
    mRecorder.release();
}