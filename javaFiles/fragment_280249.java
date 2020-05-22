ValueAnimator animator = new ValueAnimator();
animator.setObjectValues(0, count);// here you set the range, from 0 to "count" value
animator.addUpdateListener(new AnimatorUpdateListener() {
    public void onAnimationUpdate(ValueAnimator animation) {
     highscoretext.setText(String.valueOf(animation.getAnimatedValue()));
    }
});
animator.setDuration(1000); // here you set the duration of the anim
animator.start();