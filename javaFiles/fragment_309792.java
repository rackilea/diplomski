imageView.animate()
    .rotationX(360).rotationY(360)
    .setDuration(1000)
    .setInterpolator(new LinearInterpolator())
    .setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animator) {
            imageView.setRotationX(0);
            imageView.setRotationY(0);
        }
    });