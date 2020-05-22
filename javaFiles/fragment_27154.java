//just initialize inside ClickListener, speak_rost, and after .setOnCompletionListener, I put speak_rost().start; that was ALL, very nice problem, now all my 50+ buttons/layouts are "in the right form" to play 100+ time, every time I needed. Thank you.
layoutRost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                speak_rost = MediaPlayer.create(hundred.this, R.raw.asa);
                speak_rost .setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mysound) {
                        mysound.release();
                    }

                });
                speak_rost .start();
            }
        });