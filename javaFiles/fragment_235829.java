@Override
            public void onWindowFocusChanged(boolean hasFocus) {
                RunAnimations();
                super.onWindowFocusChanged(hasFocus);
            }                

                                                         can go anywhere in your main activity, then just create the run animations method and in it put anything you want to start              

    private void RunAnimations() {


   Animation   a = AnimationUtils.loadAnimation(this, R.anim.fade);
  /*  a.reset();
    logoImage = (ImageView) findViewById(R.id.dopescrawl);
    logoImage.setBackgroundResource(R.drawable.dopesplash);
    logoAnimation = (AnimationDrawable)  logoImage.getBackground();
    logoImage.clearAnimation();
    logoImage.startAnimation(a);
    */
    a = AnimationUtils.loadAnimation(this, R.anim.slide);
    a.reset();
    ImageView title = (ImageView) findViewById(R.id.dopescrawl);
    title.clearAnimation();
    title.startAnimation(a);





    //logoAnimation.start();
}