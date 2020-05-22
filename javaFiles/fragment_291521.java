float[] mirrorY = { -1, 0, 0, 0, 1, 0, 0, 0, 1};
Matrix matrix = new Matrix();
Matrix matrixMirrorY = new Matrix();
matrixMirrorY.setValues(mirrorY);

matrix.postConcat(matrixMirrorY);

image = Bitmap.createBitmap(mBitmap, 0, 0, frame.getWidth(), frame.getHeight(), matrix, true)