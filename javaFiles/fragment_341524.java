BitmapFactory.Options options = new BitmapFactory.Options();
options.inSampleSize = 2;
int index = 0;
for (int imageId : mImageIds) {
    Bitmap originalImage = BitmapFactory.decodeResource(getResources(),
            imageId, options);