Matrix matrix = new Matrix();
matrix.postRotate(90);
Bitmap bmpRotated =  Bitmap.createBitmap(bmpSource, 0, 0, bmpSource.getWidth(), bmpSource.getHeight(), matrix, true);


sourceImageRect.left = 0;
sourceImageRect.top = 0;
sourceImageRect.right = bmpRotated.getWidth();
sourceImageRect.bottom = bmpRotated.getHeight();

destImageRect.top = destTop;
destImageRect.left = destLeft;
destImageRect.right = destLeft + destWidth;
destImageRect.bottom = destTop + destHeight;

canvas.drawBitmap(bmpRotated, sourceImageRect, destImageRect, null);