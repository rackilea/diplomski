File imageFile = new File("/sdcard/myPics/clone.png");
if (imageFile.exists()){
    //load clone.jpg into your ImageView.
    Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
    BitmapDrawable drawable = new BitmapDrawable(this.getResources(), bitmap);
    myimageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    myimageView.setImageDrawable(drawable);
}