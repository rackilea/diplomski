private void applyAnimation(final View startView, final View finishView, long duration) {
    float scalingFactor = ((float)finishView.getHeight())/((float)startView.getHeight());

    ScaleAnimation scaleAnimation =  new ScaleAnimation(1f, scalingFactor,
                                                        1f, scalingFactor,
                                                        Animation.RELATIVE_TO_SELF, 0.5f,
                                                        Animation.RELATIVE_TO_SELF, 0.5f);

    scaleAnimation.setDuration(duration);
    scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

    Display display = getWindowManager().getDefaultDisplay();

    int H;

    if(Build.VERSION.SDK_INT >= 13){
        Point size = new Point();
        display.getSize(size);
        H = size.y;
    }
    else{
        H = display.getHeight();
    }

    float h = ((float)finishView.getHeight());

    float verticalDisplacement = (-(H/2)+(3*h/4));

    TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0,
                                                                   Animation.ABSOLUTE, 0,
                                                                   Animation.ABSOLUTE, 0,
                                                                   Animation.ABSOLUTE, verticalDisplacement);

    translateAnimation.setDuration(duration);
    translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

    AnimationSet animationSet = new AnimationSet(false);
    animationSet.addAnimation(scaleAnimation);
    animationSet.addAnimation(translateAnimation);
    animationSet.setFillAfter(false);

    startView.startAnimation(animationSet);
}