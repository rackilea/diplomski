mRecorder = new MediaRecorder();//INTERESTING
mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);//INTERESTING
mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
mRecorder.setOutputFile(mFileName);
mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

try {
    mRecorder.prepare();
} catch (IOException e) {
    Log.e(LOG_TAG, "prepare() failed");
}

mRecorder.start();