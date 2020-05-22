final Guideline guideline = findViewById(R.id.guideline2) ;
 ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams)guideline.getLayoutParams();
 float end =lp.guidePercent;
 ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, end);
 valueAnimator.setDuration(3000);
 valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
 valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams)guideline.getLayoutParams();
                lp.guidePercent = valueAnimator.getAnimatedFraction();
                guideline.setLayoutParams(lp);

            }
 });