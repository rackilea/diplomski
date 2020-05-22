public void doSlideUp(View view) {
    LinearLayout myView = (LinearLayout) findViewById(R.id.content_area);
    Animation slideUp = setLayoutAnim_slideup();
    myView.startAnimation(slideUp);

}

public void doSlideDown(View view) {
    RelativeLayout myView = (RelativeLayout) findViewById(R.id.content_area1);
    Animation slideDown = setLayoutAnim_slidedown();
    myView.startAnimation(slideDown);
}

public Animation setLayoutAnim_slidedown() {

    AnimationSet set = new AnimationSet(true);

    Animation animation = new TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f, Animation.RELATIVE_TO_SELF, -1.0f,
            Animation.RELATIVE_TO_SELF, 0.0f);
    animation.setDuration(2000);
    animation.setAnimationListener(new AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {

        }
    });
    set.addAnimation(animation);

    LayoutAnimationController controller = new LayoutAnimationController(
            set, 0.25f);

    return animation;
}

public Animation setLayoutAnim_slideup() {

    AnimationSet set = new AnimationSet(true);

    Animation animation = new TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, -1.0f);
    animation.setDuration(2000);
    animation.setAnimationListener(new AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {




        }
    });
    set.addAnimation(animation);
    LayoutAnimationController controller = new LayoutAnimationController(
            set, 0.25f);
    return animation;
}