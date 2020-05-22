public Bitmap getBitmap(){
  File root = android.os.Environment.getExternalStorageDirectory(); 
  File dir = new File (root.getAbsolutePath() + "/bBackground");
  File image = new File(dir, "/bBg.jpg");

  BitmapFactory.Options options = new BitmapFactory.Options();
  options.inPreferredConfig = Bitmap.Config.ARGB_8888;
  Bitmap mustOpen = BitmapFactory.decodeFile(image, options);

  ImageView imageView = (ImageView) findViewById(R.id.bofrostBgImage);
  imageView.setImageBitmap(mustOpen);
}