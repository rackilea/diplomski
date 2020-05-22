int startX = (bitmap.getWidth() > imageView.getWidth()) ? (bitmap.getWidth() - imageView.getWidth()) / 2 : 0;
int startY = (bitmap.getHeight() > imageView.getHeight()) ? (bitmap.getHeight() - imageView.getHeight()) / 2 : 0;

bitmap = Bitmap.createBitmap(bitmap,                  
    startX,        
    startY, 
    (bitmap.getWidth() > imageView.getWidth())  ? imageView.getWidth() : bitmap.getWidth(), 
    (bitmap.getHeight() > imageView.getHeight()) ? imageView.getHeight() : bitmap.getHeight());