int width, height;
        ImageView image = (ImageView) findViewById(R.id.imageViewId);
        Bitmap bMap = BitmapFactory.decodeFile(getExternalFilesDir(null) + File.separator + "AndroidTutorialPoint.jpg");
        width = 2*bMap.getWidth();
        height = 6*bMap.getHeight();
        Bitmap bMap2 = Bitmap.createScaledBitmap(bMap, width, height, false);
        image.setImageBitmap(bMap2);