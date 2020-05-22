private final BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) throws NullPointerException {
        long timeSentInMs = intent.getLongExtra("timeSent", 0L);
        String action = intent.getAction();     

        if (action.equals(BroadcastTypes.METADATA_CHANGED)) {

             trackId = intent.getStringExtra("id");

             String artistName = intent.getStringExtra("artist");
             String albumName = intent.getStringExtra("album");
             String trackName = intent.getStringExtra("track");

             trackLengthInSec = intent.getIntExtra("length", 0);

             Log.e("STATUS:", trackName);
             Log.e("STATUS:", artistName);
             Log.e("STATUS:", albumName);
             Log.e("STATUS:", "TRACK LENGTH: " + String.valueOf(trackLengthInSec));
             Log.e("STATUS:", trackId);

             Log.e("STATUS:", "POSITION: " + String.valueOf(positionInMs));

             // the new track id is always updated just before the next song is played
             // so we can safely assume that the ad has finished playing and it's time to unmute
             unMute(am);

             // reset & resume the timer                 
             lastPlayTime = 0; 
             addSeconds = 0;
             currentlyAdPlaying = false;


             if(!timerStarted)
                startTimer();

            //---------------------- IF PAUSED OR SONG CHANGED---------------------

        } else if (action.equals(BroadcastTypes.PLAYBACK_STATE_CHANGED)) {
            playing = intent.getBooleanExtra("playing", false);
            positionInMs = intent.getIntExtra("playbackPosition", 0);

            // this is just needed to correct an eventually existing offset from the real time. 
            lastPlayTime = positionInMs;
            addSeconds = 0; // Reset counter as we've now got the current position.

            checkMuteStatus(trackLengthInSec, positionInMs);


        }
    }

};


String trackId = null;
String lastTrackId = null;
int lastPlayTime = 0;
int addSeconds = 0;
int trackLengthInSec = 0;
boolean playing = false;
boolean timerStarted = false;
boolean currentlyAdPlaying = true;

void startTimer(){   
    timerStarted = true;
    new Timer(true).scheduleAtFixedRate(
        new TimerTask() {
            @Override
            public void run() { 
                if(playing && !currentlyAdPlaying) {
                    if(lastTrackId == null)
                        lastTrackId = trackId;

                    if(lastTrackId != trackId){
                        lastTrackId = trackId;                      
                        addSeconds = 1; // Track changed. Reset counter.
                    } else {                            
                        addSeconds++; // Increment counter.
                    }

                    checkMuteStatus(
                        trackLengthInSec,
                        lastPlayTime + addSeconds * 1000
                    );
                }
            }
        }, 
        1000, // Wait a second before first run
        1000 // Runs every second
    );
}

void checkMuteStatus(double trackLength, double currentTime) {

    // trackLength is in seconds, but currentTime in MS. 
    // So we should be changing trackLength to MS as well, right?
    trackLength *= 1000;

    if (Math.abs(trackLength - currentTime) < eps) {

        mute(am);            
        Log.e("STATUS:", "MUTED");

        // pause the timer, for an ad is playing.
        currentlyAdPlaying = true;

    } else {

        unMute(am);
        Log.e("STATUS:", "NOT MUTED");


    }

}