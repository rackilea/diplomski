public class MusicPlayer
{
    private final int songResId = R.raw.your_song;
    private final MediaPlayer mediaPlayer;

    public MusicPlayer(Context context)
    {
        mediaPlayer = MediaPlayer.create(context, songResId);
        mediaPlayer.setLooping(true);
    }

    public void setPlaying(boolean isPlaying)
    {
        if (isPlaying)
        {
            mediaPlayer.start();
        }
        else
        {
            mediaPlayer.stop();
        }
    }

    public void release()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}