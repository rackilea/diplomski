myImageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random randomX = new Random();

            myImageView.animate()
                    .translationX(randomX.nextInt(500 + 1))
                    .translationY(myImageView.getHeight())
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .setDuration(500)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            myImageView.animate()
                                    .translationY(bottomOfScreen)
                                    .setInterpolator(new AccelerateInterpolator())
                                    .setInterpolator(new BounceInterpolator())
                                    .setDuration(1000);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
    });