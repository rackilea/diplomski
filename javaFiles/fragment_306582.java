@Override
public boolean onTouch(View v, MotionEvent event) 
{   

    switch (event.getAction()) 
    {

    case MotionEvent.ACTION_DOWN:
    {
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    break;
    case MotionEvent.ACTION_UP:
    {
        mediaPlayer.pause();
    }
    break;
}

return true;
}