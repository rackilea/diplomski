BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
BitmapFactory.decodeResource(getResources(), R.id.myimage, options);
int imageHeight = options.outHeight;
int imageWidth = options.outWidth;
Bitmap.Config preferredConfig = options.inPreferredConfig;
LogUtils.d("size is"+(imageHeight*imageWidth*getBytesPerPixel(preferredConfig)/1024/1024)+"MB");