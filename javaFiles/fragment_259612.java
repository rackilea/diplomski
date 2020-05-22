// start the animation
myGifImageButton.setImageResource(R.drawable.animation);

// delay the animation
mHandler = new Handler();
final Runnable r = new Runnable() {
    void run() {
       // restart the activity
       Intent intent = getIntent();
       finish();
       if (intent != null) {
           startActivity(intent);
       }
    }
};
handler.postDelayed(r, 3000);