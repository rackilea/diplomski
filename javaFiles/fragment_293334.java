@Override
public void onResume()
{


    super.onResume();
    //reinicia
    Toast.makeText(this, "onResume2", Toast.LENGTH_SHORT).show();
    if (mplayer == null)
        mplayer = MediaPlayer.create(this, R.raw.forest);
    mplayer.seekTo(0);
    mplayer.setLooping(true);
    mplayer.start();
}