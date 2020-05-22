public void onClick(View v)
{
    if(v.getId() == R.id.imageButton1)
    {
        final MediaPlayer i = MediaPlayer.create(Main.this, R.raw.sound);

        if (i != null)
        {
            ...

            i.start();
        }
    }       
}