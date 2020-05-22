public Bitmap compressBySize(String pathName, int targetWidth,  
            int targetHeight) {  
        BitmapFactory.Options opts = new BitmapFactory.Options();  
        opts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName, opts);    
        int imgWidth = opts.outWidth;  
        int imgHeight = opts.outHeight;  
        int widthRatio = (int) Math.ceil(imgWidth / (float) targetWidth);  
        int heightRatio = (int) Math.ceil(imgHeight / (float) targetHeight);  
        if (widthRatio > 1 || heightRatio > 1) {  
            if (widthRatio > heightRatio) {  
                opts.inSampleSize = widthRatio;  
            } else {  
                opts.inSampleSize = heightRatio;  
            }  
        }  

        opts.inJustDecodeBounds = false;  
        bitmap = BitmapFactory.decodeFile(pathName, opts);  
        return bitmap;  
    }