Button plus5b = (Button)findViewById(R.id.button);
plus5b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        MediaPlayer mediaPlayer = MediaPlayer.create(basic_2.this, R.raw.plus);    
        // Adding an onCompletionListener to ensure the MediaPlayer releases the memory after playing
        plussound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
                mediaPlayer = null;
           }
        });
        mediaPlayer.start();

        for (int i = 1; i <= 5; i++) {
            counterValue++;
        }
        counterdown.setText(String.valueOf(counterValue));
    }
});