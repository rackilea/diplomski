void rotate(float x)
    {
        Bitmap bitmapOrg = BitmapFactory.decodeResource(getResources(),R.drawable.tedd);

        int width = bitmapOrg.getWidth();

        int height = bitmapOrg.getHeight();


        int newWidth = 200;

        int newHeight  = 200;

        // calculate the scale - in this case = 0.4f

         float scaleWidth = ((float) newWidth) / width;

         float scaleHeight = ((float) newHeight) / height;

         Matrix matrix = new Matrix();

         matrix.postScale(scaleWidth, scaleHeight);
         matrix.postRotate(x);

         Bitmap resizedBitmap = Bitmap.createBitmap(bitmapOrg, 0, 0,width, height, matrix, true);

         iv.setScaleType(ScaleType.CENTER);
         iv.setImageBitmap(resizedBitmap);
    }