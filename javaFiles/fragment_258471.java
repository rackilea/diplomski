ImageView myImageView = (ImageView) findViewById(R.id.imageView2);
AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) myImageView.getLayoutParams();
params.x = NEW_X_VALUE; //Please enter this yourself
params.y = NEW_Y_VALUE; //Be careful of DP to PX conversions
myImageView.setLayoutParams(params);
myImageView.requestLayout();