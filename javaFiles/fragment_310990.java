playNote = new Runnable() {
    public void run() {
    try{
    clips.play(noteIDs[0], realTuneVol, realTuneVol, 1, 0, 1);
    }
    catch (Throwable th){
        Log.v("ErrorInRunnable", th.toString());
    }
    }
}