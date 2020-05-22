public void insertImage(Activity activity, ViewGroup parent) {
ImageView  iv = new ImageView(activity);
iv.setImageResource(R.drawable.e);
int width = activity.getResources().getDimensionPixelSize(R.dimen.imgWidth));
int height = activity.getResources().getDimensionPixelSize(R.dimen.imgHeight));
parent.addView(iv, 2, new LayoutParams(width, height));
}