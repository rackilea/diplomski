private void loadingAmin(final TextView loading) {

            final Animation pokeLoadingAnim = new Animation() {

                    int step = 0;

                    @Override
                    protected void applyTransformation(float interpolatedTime,
                                    Transformation t) {
                            // TODO Auto-generated method stub
                            super.applyTransformation(interpolatedTime, t);
                            if (interpolatedTime == 0) {
                                    loading.setText("Loading");
                                    step = 1;
                            }
                            if ((interpolatedTime / 0.3) > step) {
                                    loading.setText(loading.getText() + ".");
                                    ++step;
                            }

                    }
            };
            pokeLoadingAnim.setDuration(2000);
            pokeLoadingAnim.setRepeatCount(Animation.INFINITE);
            pokeLoadingAnim.setInterpolator(new LinearInterpolator());
            pokeLoadingAnim.setRepeatMode(Animation.RESTART);
            loading.startAnimation(pokeLoadingAnim);
    }