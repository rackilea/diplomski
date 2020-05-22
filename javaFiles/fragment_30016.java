@Override
public Object instantiateItem(ViewGroup container, int position) {
  ImageView imageView = new ImageView(context);
  int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_small);
  imageView.setPadding(padding, padding, padding, padding);
  imageView.setScaleType(ImageView.ScaleType.FIT_XY);
  Resources r = context.getResources();
  Bitmap bmp = BitmapFactory.decodeResource(r, GalImages[position]);
  int width=200;//set your width
  int height=200;//set your height
  Bitmap resizedbitmap = Bitmap.createScaledBitmap(bmp, width, height, true);
  Drawable d = new BitmapDrawable(r,resizedbitmap);
  Drawable[] layers = new Drawable[2];
  layers[0] = d;
  layers[1] = r.getDrawable(R.drawable.yourFrame);
  LayerDrawable layerDrawable = new LayerDrawable(layers);
  imageView.setImageDrawable(layerDrawable);
  ((ViewPager) container).addView(imageView, 0);
  return imageView;
}