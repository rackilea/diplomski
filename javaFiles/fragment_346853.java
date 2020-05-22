imageView.post(new Runnable() {
        @Override
        public void run() {
            startImageAnimation();
        }
    });


 private void startImageAnimation() {
    ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "translationX",-(imageView.getWidth()), 0);
    animation.setDuration(1100);
    animation.start();
}