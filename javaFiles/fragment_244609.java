Animation cardFlipRightOut = AnimationUtils.loadAnimation(this, R.anim.card_flip_right_out);

cardFlipRightOut.setAnimationListener(new Animation.AnimationListener(){
    @Override
    public void onAnimationStart(Animation arg0) {
    }           
    @Override
    public void onAnimationRepeat(Animation arg0) {
    }           
    @Override
    public void onAnimationEnd(Animation arg0) {
                Animation cardFlipLeftIn = AnimationUtils.loadAnimation(this, R.anim.card_flip_left_in);
                cardFrontView.startAnimation(cardFlipLeftIn);
    }
});


cardBackView.startAnimation(cardFlipRightIn);