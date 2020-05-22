int inSample = 8;

opts = new BitmapFactory.Options();
opts.inSampleSize = inSample;

Bitmap b = BitmapFactory.decodeFile(pathToImage, opts); // this bitmap will be 1/8 the size of the original