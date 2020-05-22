boolean hasAnimationStarted;

public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    if (hasFocus && !hasAnimationStarted) {
        hasAnimationStarted=true;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        ObjectAnimator translationY = ObjectAnimator.ofFloat(imageview, "y", metrics.heightPixels / 2 - imageview.getHeight() / 2); // metrics.heightPixels or root.getHeight()
        translationY.setDuration(500);
        translationY.start();
    }
}