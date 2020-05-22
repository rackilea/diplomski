Paint paint = new Paint();
paint.setStyle(Paint.Style.FILL);
paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));

polyPath.setFillType(Path.FillType.INVERSE_WINDING);

Bitmap newBitmap = Bitmap.createBitmap(bitmap, minX, minY, maxX-minX, maxY-minY);
Canvas canvas = new Canvas(newBitmap);

canvas.drawPath(polyPath, paint);   
canvas.drawBitmap(newBitmap, 0, 0, paint);