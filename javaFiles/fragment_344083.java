final View brush = findViewById(R.id.brush);
final View paint = findViewById(R.id.paint);

final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
animator.setRepeatCount(ValueAnimator.INFINITE);
animator.setDuration(6000L);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        final float progress = (float) valueAnimator.getAnimatedValue();
        paint.setTranslationX(-paint.getWidth() * (1.0f - progress));
        brush.setTranslationX(paint.getWidth() * progress);
    }
});
animator.start();