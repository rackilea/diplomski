OnFocusChangeListener itemFocusChangeListener = new OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
                int focus = 0;
        if (hasFocus) {
            focus = R.anim.enlarge;
        } else {
            focus = R.anim.decrease;
        }
        Animation mAnimation = AnimationUtils.loadAnimation(
                getActivity().getApplication(), focus);
        mAnimation.setBackgroundColor(Color.TRANSPARENT);
        mAnimation.setFillAfter(hasFocus);
        v.startAnimation(mAnimation);
        mAnimation.start();
        v.bringToFront();
    }
};