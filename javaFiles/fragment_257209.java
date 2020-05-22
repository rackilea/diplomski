ValueAnimator animator = ValueAnimator.ofInt(100, percent);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mViewTop.getLayoutParams();
                float v = ((Float.parseFloat(animation.getAnimatedValue().toString())) / 100f) -0.1f;
                if (v<0){
                    v=0;
                }
                params.verticalBias = v;
                mViewTop.setLayoutParams(params);
            }
        });
        animator.start();