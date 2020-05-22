Animation animLeft2Center = AnimationUtils.loadAnimation(this, R.anim.translate_left_to_center);

mLogo.startAnimation(animLeft2Center);  
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    //Do something after 1 second
      Animation animCenter2Right = AnimationUtils.loadAnimation(this, R.anim.translate_center_to_right);
      mLogo.startAnimation(animCenter2Right);
  }
}, 1000);