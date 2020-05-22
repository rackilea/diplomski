AlphaAnimation fadeOutAnimation = new AlphaAnimation(1, 0); // start alpha, end alpha
fadeOutAnimation.setDuration(1000); // time for animation in milliseconds
fadeOutAnimation.setFillAfter(true); // make the transformation persist
fadeOutAnimation.setAnimationListener(new AnimationListener() {         
    @Override
    public void onAnimationEnd(Animation animation) {
        linearLayout.setVisibility(View.GONE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) { }

    @Override
    public void onAnimationStart(Animation animation) { }
});

linearLayout.setAnimation(fadeOutAnimation);