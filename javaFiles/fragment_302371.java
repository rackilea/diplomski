private void startRecording() {
    recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
            RECORDER_SAMPLERATE, RECORDER_CHANNELS,
            RECORDER_AUDIO_ENCODING, BufferElements2Rec * BytesPerElement);
    recorder.startRecording();
    isRecording = true;
    recordingThread = new Thread(new Runnable() {
        public void run() {
            writeAudioDataToFile();
        }
    }, "AudioRecorder Thread");
    recordingThread.start();
}