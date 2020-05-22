final ObjectAnimator animator = ObjectAnimator.ofFloat(tickerView, "scaleY", 0);
    animator.setDuration(500);
    animator.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            ticker_counter++;
            animation.setStartDelay(5000);
            animator.start();
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    });
    animator.start();