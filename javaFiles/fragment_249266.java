mButton1 = (Button)findViewById(R.id.button1);
mButton2 = (Button)findViewById(R.id.button2);

mAnimation = new AlphaAnimation(1, 0);
mAnimation.setDuration(500);
mAnimation.setInterpolator(new LinearInterpolator());
mAnimation.setRepeatCount(Animation.INFINITE);
mAnimation.setRepeatMode(Animation.REVERSE);

mBbutton1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mButton2.clearAnimation();
        mButton1.startAnimation(mAnimation);
    }
});

mBbutton2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mButton1.clearAnimation();
        mButton2.startAnimation(mAnimation);
    }
});