RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
RectF dst = new RectF(0, 0, getWidth(), getHeight());

matrix = new Matrix();
matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);

Log.d(TAG, "MATRIX VALUE: " + matrix);

canvas.drawBitmap(bitmap, matrix, null);