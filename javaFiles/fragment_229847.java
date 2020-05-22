Button btnSpeaker = (Button)findViewById(R.id.btnSpeaker);
                btnSpeaker.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MediaPlayer mp;
                        mp=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(word.toLowerCase(),"raw",getPackageName()));
                        mp.start();
                    }
                });