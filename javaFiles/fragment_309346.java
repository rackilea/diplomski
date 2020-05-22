animation.setAnimationListener(new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
            // You can hide ActionBar here
            getActivity().getActionBar().hide();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // getActivity().getActionBar().show();
            // and according to you, use Handler
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    getActivity().getActionBar().show();
                }
            }, 3 * 1000);
        }
    });
    someTextView.startAnimation(animation);