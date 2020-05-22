int width = bitmap.getWidth();
int height = bitmap.getHeight();

float scaleWidth = ((float) newWidth) / width;
float scaleHeight = ((float) newHeight) / height;      

matrix = new Matrix();

matrix.postScale(scaleWidth, scaleHeight);

Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                    width, height, matrix, true);