private void setPic(ImageView myImageView) {
    // Get the dimensions of the View
    int targetW = myImageView.getWidth();
    int targetH = myImageView.getHeight();

    String path = mCurrentPhotoPath.replace("/file:","");

    // Get the dimensions of the bitmap
    BitmapFactory.Options bmOptions = new BitmapFactory.Options();
    bmOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(path, bmOptions);
    int photoW = bmOptions.outWidth;
    int photoH = bmOptions.outHeight;
    Log.v("IMG Size", "IMG Size= " + String.valueOf(photoW) + " X " + String.valueOf(photoH));

    // Determine how much to scale down the image
    int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

    // Decode the image file into a Bitmap sized to fill the View
    bmOptions.inJustDecodeBounds = false;
    bmOptions.inSampleSize = scaleFactor;
    bmOptions.inPurgeable = true;

    Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
    myImageView.setImageBitmap(bitmap);
}