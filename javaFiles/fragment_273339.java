float angle;
  float radius;

  Bitmap wheelSelectBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
  Matrix matrix = new Matrix();

  Point pivotPoint = new Point();
  pivotPoint.set(pivotPoint.x, pivotPoint.y)
  Point newCenter = new Point();
  newCenter.set((int)(pivotPoint.x + (radius * Math.cos(angle)), (int)(pivotPoint.y - (radius * Math.sin(angle)));

  matrix.postTranslate(newCenter.x - (bitmap.getWidth()/2f), newCenter.y - (bitmap.getHeight()/2f));
  matrix.postRotate(angle, newCenter.x, newCenter.y);

  Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), null, true);
  canvas.drawBitmap(bitmap, matrix, null);