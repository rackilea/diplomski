String val = " ";
        val = sharedPref.getString("key", " ");

        // empty SharedPreferences
        if ( ! val.equals(" ")) {

            // get all images from external storage
            for (i = 1; i <= Constants.TRAIN_SAMPLES; i++) {

                String photoPath = Environment.getExternalStorageDirectory().toString() + "/ramki/ramka_" + i + ".png";
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(photoPath, options);

                Utils.bitmapToMat(bitmap, img);

                if (img.channels() == 3) {
                    Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
                } else if (img.channels() == 4) {
                    Imgproc.cvtColor(img, img, Imgproc.COLOR_RGBA2GRAY);
                }

                Imgproc.resize(img, img, new Size(200, 200));
                img.convertTo(img, CvType.CV_32FC1);
                img = img.reshape(1, 1); //  1 x 40 000 ( 200x200 )

                trainData.push_back(img);
                publishProgress(i);
            }

            // save this trainData (Mat) to SharedPreferences
            saveMatToPref(trainData);

        } else {
            // get trainData from SharedPreferences
            val = sharedPref.getString("key", " ");

            byte[] data = Base64.decode(val, Base64.DEFAULT);

            trainData = new Mat(Constants.TRAIN_SAMPLES, 200 * 200, CvType.CV_32FC1); 

            float[] f = toFloatArray(data);

            trainData.put(0, 0, f);
        }

        knn.train(trainData, Ml.ROW_SAMPLE, trainClasses);



  public void saveMatToPref(Mat mat) {

    if (mat.isContinuous()) {

        int size = (int)( mat.total() * mat.channels() );

        float[] data = new float[ size ];

        byte[] b = new byte[ size ];

        mat.get(0, 0, data);

        b = FloatArray2ByteArray(data);

        String dataString = new String(Base64.encode(b, Base64.DEFAULT));

        SharedPreferences.Editor mEdit1 = sharedPref.edit();
        mEdit1.putString("key", dataString);

        mEdit1.commit();

    } else {
        Log.i(TAG, "Mat not continuous.");
    }
}

private static float[] toFloatArray(byte[] bytes) {
    ByteBuffer buffer = ByteBuffer.wrap(bytes);
    FloatBuffer fb = buffer.asFloatBuffer();
    float[] floatArray = new float[fb.limit()];
    fb.get(floatArray);
    return floatArray;
}

public static byte[] FloatArray2ByteArray(float[] values){
    ByteBuffer buffer = ByteBuffer.allocate(4 * values.length);

    for (float value : values)
        buffer.putFloat(value);

    return buffer.array();
}