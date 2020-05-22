int width = bm.getWidth();

    int height = bm.getHeight();

    float scaleWidth = ((float) newWidth) / width;

    float scaleHeight = ((float) newHeight) / height;



    Matrix matrix = new Matrix();



    matrix.postScale(scaleWidth, scaleHeight);



    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);

    return resizedBitmap;

}