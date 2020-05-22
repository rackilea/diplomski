Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yourImage);


Rect mRect= new Rect(x1, y1, x2, y2); 

assert(mRect.left < mRect.right && mRect.top < mRect.bottom);

Bitmap croppedImage = Bitmap.createBitmap(rect.right-rect.left, rect.bottom-rect.top, Bitmap.Config.ARGB_8888);

new Canvas(croppedImage).drawBitmap(mBitmap, -rect.left, -rect.top, null);