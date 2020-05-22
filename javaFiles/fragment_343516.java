private Bitmap sampleImage(Bitmap bitmap, int reqWidth, int reqHight) {


        //first decode
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile("FILE_PATH",options);
        //seconde deconde
        options.inSampleSize = caculateSampleSize(options,reqWidth,reqHight);
        options.inJustDecodeBounds = false;


        bitmap = BitmapFactory.decodeFile("FILE_PATH",options);
         return bitmap;

    }

private int caculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHight) {
    int screenWidth;
    int screenHight;
    screenWidth = (reqWidth == 0 ? this.getResources().getDisplayMetrics().widthPixels : reqWidth);
    screenHight = (reqHight == 0 ? this.getResources().getDisplayMetrics().heightPixels : reqHight);
    int sampleWith = options.outWidth / screenWidth;
    int sampleHight = options.outHeight / screenHight;
    //use max
    return  sampleWith > sampleHight ? sampleWith : sampleHight;
}