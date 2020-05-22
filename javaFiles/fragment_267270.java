public void animFab() {  

    ObjectAnimator scaleX = ObjectAnimator.ofFloat(fab, View.SCALE_X, from, to);  
    ObjectAnimator scaleY = ObjectAnimator.ofFloat(fab, View.SCALE_Y, from, to);  
    AnimatorSet set1 = new AnimatorSet();  

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  
        ObjectAnimator translationZ = ObjectAnimator.ofFloat(fab, View.TRANSLATION_Z, from, to);  
        set1.playTogether(scaleX, scaleY, translationZ);  

    } else {  
        set1.playTogether(scaleX, scaleY);  
    }  
    set1.setDuration(500);  
    set1.setInterpolator(new AccelerateInterpolator());  
    set1.addListener(new AnimatorListenerAdapter() {  
        @Override  
  public void onAnimationEnd(Animator animation) {  

        }  
    });  

    Path path = new Path();  
    path.moveTo(0.0f, 0.0f);  
    path.lineTo(0.5f, 1.3f);  
    path.lineTo(0.75f, 0.8f);  
    path.lineTo(1.0f, 1.0f);  
    Interpolator pathInterpolator = PathInterpolatorCompat.create(path);  

    AnimatorSet set2 = new AnimatorSet();  
    ObjectAnimator scaleXBack = ObjectAnimator.ofFloat(fab, View.SCALE_X, to, from);  
    ObjectAnimator scaleYBack = ObjectAnimator.ofFloat(fab, View.SCALE_Y, to, from);  

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  
        ObjectAnimator translationZBack = ObjectAnimator.ofFloat(fab, View.TRANSLATION_Z, to, from);  
        set2.playTogether(scaleXBack, scaleYBack, translationZBack);  
    } else {  
        set2.playTogether(scaleXBack, scaleYBack);  
    }  
    set2.setDuration(500);  
    set2.setInterpolator(pathInterpolator);  

    final AnimatorSet set = new AnimatorSet();  
    set.playSequentially(set1, set2);  

    set.addListener(new AnimatorListenerAdapter() {  
        @Override  
  public void onAnimationEnd(Animator animation) {  
            super.onAnimationEnd(animation);  
            set.start();  
        }  
    });  
    set.start();  
}