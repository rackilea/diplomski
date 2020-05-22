w.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        black.cancel();
        //using the elapsed time to start a new timer
        totalBlack = totalBlack - blackElapsed;
        //this preserves milliseconds by ticking every millisecond
        white = new CountDownTimer(totalBlack, 1){
            @Override
            public void onTick(long l) {
                B.setText(l+"");
                blackElapsed=totalBlack-l;  //updating the elapsed time
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }
});
//we do a similar thing with the other player's button
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        white.cancel();
        totalWhite = totalWhite - whiteElapsed;
        black = new CountDownTimer(totalWhite, 1){
            @Override
            public void onTick(long l) {
                W.setText(l+"");
                whiteElapsed=totalWhite-l;
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }
});