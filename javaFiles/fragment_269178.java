{
    final ImageView image = (ImageView)findViewById(R.id.imageView2);
    final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

    Animation.AnimationListener animListener = new Animation.AnimationListener(){

        // Required to change the image
        int count = 0;

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if (animation == animationFadeIn) {

                // Start fade-out animation
                image.startAnimation(animationFadeOut);

            } else if (animation == animationFadeOut) {

                count++;

                // Set next image after fading out previous image
                switch (count) {
                    case 1:
                        image.setImageResource(R.drawable.picture002);
                        image.startAnimation(animationFadeIn);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.picture003);
                        image.startAnimation(animationFadeIn);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.picture004);
                        image.startAnimation(animationFadeIn);
                        break;
                    default:
                        break;
                }
            }
        }
    };

    // Set listener to animation
    animationFadeIn.setAnimationListener(animListener);
    animationFadeOut.setAnimationListener(animListener);

    // Start fade-in animation
    image.setImageResource(R.drawable.picture001);
    image.startAnimation(animationFadeIn);

}