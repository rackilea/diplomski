public static AnimatorSet createAnimationCollapseXY(View view) {
    ObjectAnimator scaleXOut = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f).setDuration(400);
    ObjectAnimator scaleXIn = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f).setDuration(300);
    ObjectAnimator scaleYOut = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f).setDuration(400);
    ObjectAnimator scaleYIn = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f).setDuration(300);
    ObjectAnimator rotateClockWise = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f).setDuration(400);
    ObjectAnimator rotateCounterClockWise = ObjectAnimator.ofFloat(view, "rotation", 0f, -360f).setDuration(400);


    AnimatorSet animatorSet = new AnimatorSet();

    animatorSet.playTogether(scaleXIn, scaleYIn);
    //animatorSet.setStartDelay(1200);
    animatorSet.start();
    return animatorSet;
}