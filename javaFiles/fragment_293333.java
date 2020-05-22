@Override
public void onPause()
{
    super.onPause();
    Toast.makeText(this, "onPause2", Toast.LENGTH_SHORT).show();
    //LIBERA A MEDIA PLAYER
    if (mplayer != null)
    {
        mplayer.release();
        mplayer = null;
    }

}