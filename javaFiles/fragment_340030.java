Animation animation = new Animation() {
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            abortIndicatorView.getLayoutParams().width = (int) (radius * interpolatedTime);
            abortIndicatorView.getLayoutParams().height = (int) (radius * interpolatedTime);
            abortIndicatorView.requestLayout();// Add this line
        }

        @Override
        public boolean willChangeBounds() {
            return true;
        }
    };
animation.setDuration(1000);

abortIndicatorView.startAnimation(animation);