public void setWallpaper() {
  Context context = this.getBaseContext(); 
  Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), mImageIds[pos]);

  context.setWallpaper(mBitmap);
}