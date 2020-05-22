Bitmap  bitmap = BitmapFactory.decodeFile(path, options);
                 try {

                        ExifInterface exif = new ExifInterface(path);
                        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

                        int angle = 0;

                        if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
                            angle = 90;
                        } 
                        else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
                            angle = 180;
                        } 
                        else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
                            angle = 270;
                        }
                        Matrix mat = new Matrix();
                        mat.postRotate(angle);
                        Bitmap correctBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mat, true);                 
                    bitmap=correctBmp;
                 }
                 catch(Exception e){

                 }