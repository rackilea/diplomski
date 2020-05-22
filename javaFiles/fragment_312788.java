protected Object doInBackground(Object[] params) {
        int i = 0;
        soundMeter = new SoundMeter();
        RecordingHandler recordingHandler = null;
        try {
            soundMeter.start("/dev/null");
        } catch (IOException e) {
            Log.e("error", e.getMessage());
        }
        while(true){
            if(isCancelled()){
                soundMeter.stop();
                if(currentlyRecording && recordingHandler != null){
                    recordingHandler.kill();
                }
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.e("error", e.getMessage());
            }
            if(!currentlyRecording && soundMeter.getAmplitudeEMA() > 4.0){
                soundMeter.stop();
                recordingHandler =  new RecordingHandler(deviceId);
                currentlyRecording = true;
                recordingHandler.run();
            } else if(!currentlyRecording && !soundMeter.isRunning()){
                try {
                    soundMeter.start("/dev/null");
                } catch (IOException e) {
                    Log.e("error", e.getMessage());
                }
            }
        }
        return null;
    }
}