public ValueAnimator slideAnimator(int start, int end,TextView txtSubtitle) {

    final ValueAnimator animator = ValueAnimator.ofInt(start, end);

    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            // update height
            int value = (Integer) valueAnimator.getAnimatedValue();

            ViewGroup.LayoutParams layoutParamsTV = txtSubtitle.getLayoutParams();
            layoutParamsTV.height = value;
            txtSubtitle.setLayoutParams(layoutParamsTV);
        }
    });
    return animator;
}