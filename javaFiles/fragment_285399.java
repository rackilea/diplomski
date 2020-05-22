public class MediaPlayerSingleton implements MediaPlayer.OnPreparedListener {

    private static MediaPlayerSingleton instance = null;
    private MediaPlayer mediaPlayer = null;

    private MediaPlayerSingleton() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(this);
    }

    public static MediaPlayerSingleton getInstance() {
        if (instance == null) {
            instance = new MediaPlayerSingleton();
        }
        return instance;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {   
        resume();
    }

    /**
     * This will load the given URL into the media player.
     * @param url The URL string from the Firebase Uri.
     */
    public void play(String url) {  
        try {
            mediaPlayer.reset()
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void resume() {
        mediaPlayer.start();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void release() {
        mediaPlayer.release();
    }
}