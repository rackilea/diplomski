@Override
public void run() {
    int i = 0;
    try {
        soundMeter.start(getFileNameString());
    } catch (IOException e) {
        Log.e("error", e.getMessage());
    }
    while(true){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Log.e("error", e.getMessage());
        }
        if(isKilled){
            break;
        }
        if(soundMeter.getAmplitudeEMA() < 4.0){
            i++;
            if(i > 10){
                break;
            }
        } else {
            i = 0;
        }
    }
    soundMeter.stop();
    EavesDrop.currentlyRecording = false;
}