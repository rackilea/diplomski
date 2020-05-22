public void jpg2mat() {
        File jpeg1 = new File(Environment.getExternalStorageDirectory() + "/dirName/img.jpg");
        Bitmap bmp1 = BitmapFactory.decodeFile(jpeg1.getAbsolutePath());

        Mat mat1 = new Mat();
        Utils.bitmapToMat(bmp1, mat1);
    }