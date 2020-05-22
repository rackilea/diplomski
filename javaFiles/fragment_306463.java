AnimatorSet animatorSet = new AnimatorSet();
    ObjectAnimator fadeIn = ObjectAnimator.ofInt(drawableIcon, "alpha", 0, 255);
    ObjectAnimator fadeOut = ObjectAnimator.ofInt(drawableIcon, "alpha", 255, 0);
    fadeIn.setDuration(300);
    fadeOut.setDuration(300);
    fadeOut.setStartDelay(500);

    animatorSet.playSequentially(fadeIn, fadeOut);
    animatorSet.setDuration(1100);
    animatorSet.addListener(new AnimatorListenerAdapter() {

        private boolean mCanceled;

        @Override
        public void onAnimationStart(Animator animation) {
            mCanceled = false;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            mCanceled = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (!mCanceled) {
                animation.start();
            }
        }

    });
    animatorSet.start();