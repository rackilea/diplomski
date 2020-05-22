// This needs to replace your "mp" variable.
List<MediaPlayer> mps = new ArrayList<MediaPlayer>();


// Play button code ....
// Make sure all the media are prepared before playing
for (int i = 0; i < InstrumentCountSize; i++) {
    MediaPlayer mp = new MediaPlayer();
    mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
    mp.setDataSource(instruments_count.get(i));
    mp.prepare();
    mps.add(mp);
}
// Now that all the media are prepared, start playing them.
// This should allow them to start playing at (approximately) the same time.
for (MediaPlayer mp: mps) {
    mp.start(); 
}


// Pause button code ...
for (MediaPlayer mp: mps) {
    try { 
        mp.stop(); 
        mp.reset(); 
        mp.release(); 
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
mps.clear();