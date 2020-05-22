private void blinkEffectRed1(){
  ObjectAnimator animator = ObjectAnimator.ofInt(mButtonChoice1, "backgroundColor", Color.RED , Color.parseColor(("#ff669900")));
  animator.setDuration(250);
  animator.setEvaluator(new ArgbEvaluator());
  animator.setRepeatCount(2);
  animator.setRepeatMode(ValueAnimator.REVERSE);

  // Adding the listener
  animator.addListener(new AnimatorListenerAdapter() {
    @Override
    public void onAnimationEnd(Animator animation) {
        // Update the button when animation ends...
        mButtonChoice1.setBackgroundResource(R.drawable.rounded_button);
        updateQuestion();
    }
  });

  animator.start();
}