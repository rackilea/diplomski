public void hideImageAnimated(final ImageView iv) {

    Animation alpha = new AlphaAnimation(1.0f, 0.0f);
    alpha.setDuration(1000); // whatever duration you want

    // add AnimationListener
    alpha.setAnimationListener(new AnimationListener(){

        @Override
        public void onAnimationEnd(Animation arg0) {
            iv.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation arg0) { }

        @Override
        public void onAnimationStart(Animation arg0) { }

    });

    iv.startAnimation(alpha);
}