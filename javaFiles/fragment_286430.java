songListTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (mediaPlayer != null && mediaPlayer.isPlaying() && null!=bass.getDrawable()) {

                    mediaPlayer.stop();
                    //trying to remove gif from last song
                    if(lastBass!=null)
                        lastBass.setVisibility(View.GONE);
                    bass.setVisibility(View.GONE);

                }else {
                     if(lastBass!=null)
                        lastBass.setVisibility(View.GONE);
                    //trying to put back gif over here on current song
                    bass.setVisibility(View.VISIBLE);

                }



                try {

                        String f = Environment.getExternalStorageDirectory().getAbsolutePath() + "/music/" + list.getSongName().toString() + ".mp3";

                        Uri uri = Uri.parse(f);

                        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), uri);

                        bass.setImageResource(R.drawable.bass);
                        bass.setVisibility(View.VISIBLE); // add this line
                        mediaPlayer.start();
                        lastBass=bass;  // initialize lastBass here

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

            }

        });