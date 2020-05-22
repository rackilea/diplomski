mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        b = (ImageButton) bottomSheet.findViewById(R.id.imageButton);

        new PlayerTask().execute(s);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(started)
                {
                    mediaPlayer.start();
                }
            }
        }); 
class PlayerTask extends AsyncTask<String, Void, Boolean>
{

    @Override
    protected Boolean doInBackground(String... strings) {


        try
        {
            mediaPlayer.setDataSource(strings[0]);
            mediaPlayer.prepare();
            prepared = true;
        } catch(IOException e)
        {
            e.printStackTrace();
        }

        return prepared;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean)
    {
        super.onPostExecute(aBoolean);
        mediaPlayer.start();
    }
}