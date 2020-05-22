Bitmap bitmap = YOUR_BITMAP;
    //rotate bitmap
    Matrix matrix = new Matrix();               
    matrix.postRotate(orientation);
    //create new rotated bitmap
    bitmap = Bitmap.createBitmap(bitmap, 0, 0,bitmap.getWidth(), bitmap.getHeight(), matrix, true);  
   YOUR_IMAGE_VIEW.setImageBitmap(bitmap);