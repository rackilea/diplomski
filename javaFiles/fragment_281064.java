PropertyValuesHolder scalex = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.2f);
PropertyValuesHolder scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.2f);
ObjectAnimator anim = ObjectAnimator.ofPropertyValuesHolder(btn_layer, scalex, scaley);
anim.setRepeatCount(ValueAnimator.INFINITE);
anim.setRepeatMode(ValueAnimator.REVERSE);
anim.setDuration(1500);
anim.start();