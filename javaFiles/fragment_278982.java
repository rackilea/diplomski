SeekBar seekBar;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...

        seekBar = (SeekBar) findViewById(R.id.seekbar);

        ...
    }

    ...

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_OPEN_FILE) {
            if (resultCode == RESULT_OK) {
                audioFileUri = data.getData();
                try {

                    if (mediaPlayer.isPlaying()) {
                        seekBar.setProgress(0);
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(this, audioFileUri);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        seekBar.setMax(mediaPlayer.getDuration()); // Set the Maximum range of the
                        Toast.makeText(this, "Was Playing", Toast.LENGTH_SHORT);
                    } else {
                        seekBar.setProgress(0);
                        mediaPlayer.setDataSource(this, audioFileUri);
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        seekBar.setMax(mediaPlayer.getDuration()); // Set the Maximum range of the
                        /*seekBar.getVisibility();
                        seekBar.setVisibility(View.INVISIBLE);*/
                        Toast.makeText(this, "Was not playing", Toast.LENGTH_SHORT);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                int mediaPos = mediaPlayer.getCurrentPosition();
                int mediaMax = mediaPlayer.getDuration();
                seekBar.setMax(mediaMax); // Set the Maximum range of the
                seekBar.setProgress(mediaPos);// set current progress to song's

                handler.removeCallbacks(moveSeekBarThread);
                handler.postDelayed(moveSeekBarThread, 1000);
            }

        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    seekBar.setProgress(progress);
                    mediaPlayer.seekTo(progress);
                }
                else{}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


private Runnable moveSeekBarThread = new Runnable() {
    public void run() {
        if(mediaPlayer.isPlaying()){
            int mediaPos_new = mediaPlayer.getCurrentPosition();
            int mediaMax_new = mediaPlayer.getDuration();
            seekBar.setMax(mediaMax_new);
            seekBar.setProgress(mediaPos_new);
            handler.postDelayed(this, 100); //Looping the thread after 0.1 second
            // seconds
        }else if(mediaPlayer.getCurrentPosition() == mediaPlayer.getDuration()){}
    }
};