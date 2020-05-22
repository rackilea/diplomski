if (tv2.animation != null) tv2.animation.setAnimationListener(null)//needed not in all cases
tv2.clearAnimation()

anim.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {
      tv2.setVisibility(View.VISIBLE);
    }
    @Override
    public void onAnimationEnd(Animation animation) {
    }
    @Override
    public void onAnimationRepeat(Animation animation) {}
  });
  tv2.startAnimation(anim);