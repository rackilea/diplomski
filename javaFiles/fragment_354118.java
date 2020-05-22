protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (resultCode == RESULT_OK) {
    if (requestCode == REQUEST_IMAGE_CAPTURE) {
        final boolean isCamera;
        if (data == null) {
            isCamera = true;
        } else {
            final String action = data.getAction();
            if (action == null) {
                isCamera = false;
            } else {
                isCamera = action
                        .equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            }
        }

        Uri selectedImageUri;
        if (isCamera) {
            selectedImageUri = outputFileUri;
        } else {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = activity.getContentResolver().query(
                    selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            selectedImageUri = cursor.getString(columnIndex);
            cursor.close();
        }

        ImageButton pic1 = (ImageButton) findViewById(R.id.ibPic1);
        Toast.makeText(this, "Image saved to:\n" + selectedImageUri,
                Toast.LENGTH_LONG).show();
        //.setImageURI(selectedImageUri);
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImageUri, options);
        options.inSampleSize = calculateInSampleSize(options, dpToPx(100),
                dpToPx(100));

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        Bitmap bMapRotate = BitmapFactory.decodeFile(filePath, options);
        int width = bMapRotate.getWidth();
        int height = bMapRotate.getHeight();
        if (width > height)
            para = height;
        else
            para = width;
        if (bMapRotate != null) {
            pic1.setImageBitmap(bMapRotate);
        }
    }
}

private int dpToPx(int dp) {
    float density = activity.getResources().getDisplayMetrics().density;
    return Math.round((float) dp * density);
}

public static int calculateInSampleSize(BitmapFactory.Options options,
        int reqWidth, int reqHeight) {
    // Raw height and width of image
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {

        // Calculate ratios of height and width to requested height and
        // width
        final int heightRatio = Math.round((float) height
                / (float) reqHeight);
        final int widthRatio = Math.round((float) width / (float) reqWidth);

        // Choose the smallest ratio as inSampleSize value, this will
        // guarantee
        // a final image with both dimensions larger than or equal to the
        // requested height and width.
        inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }

    return inSampleSize;
}