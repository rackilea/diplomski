final RotateAnimation animation=new RotateAnimation(0f,360f, RotateAnimation.RELATIVE_TO_SELF,0.5f,
        RotateAnimation.RELATIVE_TO_SELF,0.5f);
    animation.setDuration(1000);

    animation.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Random rand = new Random();
            int number = rand.nextInt() % 3;
            if (number == 1) {
                imgRed.startAnimation(animation);
            }
            else if (number == 2) {
                imgGreen.startAnimation(animation);
            }
            else {
                imgBlue.startAnimation(animation);
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
     });