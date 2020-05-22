private void saveBitmap(String name, Bitmap bitmap, String timeStamp) {
  File photo = CommonUtil.getFileName(timeStamp, name);
  if (photo.exists()) photo.delete();
  try {
         Bitmap image = applyBrightnessContrast(bitmap);
         FileOutputStream fos = new FileOutputStream(photo.getPath());
         image.compress(Bitmap.CompressFormat.JPEG, 100, fos);
         fos.close();
         CommonUtil.showProgressDialog(mContext, null, false);
      } catch (java.io.IOException e) {
         CommonUtil.showProgressDialog(mContext, null, false);
         Log.e("PictureDemo", "Exception in photoCallback", e);
      }
  if(mLocation != null)// check we have location or not
     markGeoTagImage(photo.getPath(),mLocation);
}