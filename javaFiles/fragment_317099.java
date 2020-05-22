public void loadImage() {

    Picasso.with(getBaseContext()).load("image url").into(new Target() {
            // ....

            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom arg1) {
                // Pick arbitrary values for width and height
                Bitmap resizedBitmap = getResizedBitmap(bitmap, newWidth, newHeight);
                mImageView.setBitmap(resizedBitmap);
            }

            // ....
        });
    }
}

public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
    int width = bm.getWidth();
    int height = bm.getHeight();
    float scaleWidth = ((float) newWidth) / width;
    float scaleHeight = ((float) newHeight) / height;
    // CREATE A MATRIX FOR THE MANIPULATION
    Matrix matrix = new Matrix();
    // RESIZE THE BIT MAP
    matrix.postScale(scaleWidth, scaleHeight);

    // "RECREATE" THE NEW BITMAP
    Bitmap resizedBitmap = Bitmap.createBitmap(
    bm, 0, 0, width, height, matrix, false);
    bm.recycle();
    return resizedBitmap;
}