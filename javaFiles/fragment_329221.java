for(int x=0; x<rows; x++){
        int xCoord = 0;
        for(int y=0; y<cols; y++){
            Bitmap image = Bitmap.createBitmap(scaledBitmap, xCoord, yCoord, chunkWidth, chunkHeight);
            Uri uri = saveBitmapAsFile(image);
            image.recycle();
            xCoord += chunkWidth;
        }
        yCoord += chunkHeight;
    }