void heartFlurry() {

    Drawable heart = getResources().getDrawable( R.drawable.heart );
    View v = new ImageView(getBaseContext());
    ImageView imageView;
    imageView = new ImageView(v.getContext());
    imageView.setImageDrawable(heart);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;
    Log.e("Width", "" + width);
    Log.e("height", "" + height);

    final int randomX = new Random().nextInt(size.x);
    Log.e("randomX", "" + randomX);

    RelativeLayout.LayoutParams paramsImage = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    paramsImage.addRule(RelativeLayout.CENTER_IN_PARENT);
    imageView.setLayoutParams(paramsImage);
    relativeLayout.addView(imageView);

    RelativeLayout.LayoutParams heartParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
    );
    heartParams.leftMargin = randomX;
    heartParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
    imageView.setLayoutParams(heartParams);

    ObjectAnimator animationY = ObjectAnimator.ofFloat(imageView, "translationY", -size.y);
    animationY.setDuration(500);
    animationY.start();

    new CountDownTimer(1000, 1000) {
        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
           relativeLayout.removeAllViews();
            Log.e("randomX", "Timer Done");

        }
    }.start();

}