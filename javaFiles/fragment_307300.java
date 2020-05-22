AppCompatButton mBtn = (AppCompatButton) view.findViewById(R.id.search_btn);
        Animation mRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);
mBtn.setAnimation(mRotateAnimation);
mBtn.startAnimation(mRotateAnimation);

int colorFrom = getResources().getColor(R.color.red);
int colorTo = getResources().getColor(R.color.blue);
ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
colorAnimation.setDuration(600);
colorAnimation.addUpdateListener(new AnimatorUpdateListener() {

    @Override
    public void onAnimationUpdate(ValueAnimator animator) {
        mBtn.setBackgroundColor((int) animator.getAnimatedValue());
    }

});
colorAnimation.start();