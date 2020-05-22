private void updateImageView () {
        //  ... your code to update ImageView matrix ...
        // 
        // imageToCrop.setImageMatrix(m);
        // imageToCrop.postInvalidateDelayed(10);

        if (Build.VERSION.SDK_INT >= 10) {
            ImageView hiresImage = (ImageView) findViewById(R.id.hiresImage);
            hiresImage.setImageDrawable(null);
            hiresImage.invalidate();
            if (loadHiResImageTask.getStatus() != AsyncTask.Status.FINISHED) {
                loadHiResImageTask.cancel(true);
            }
            loadHiResImageTask = null;
            loadHiResImageTask = new LoadHiResImageTask();
            loadHiResImageTask.execute(
                    (double) hiresImage.getWidth(),
                    (double) hiresImage.getHeight(),
                    // x, y, fw, fh are properties from the question
                    (double) x / d.getIntrinsicWidth(),
                    (double) y / d.getIntrinsicHeight(),
                    (double) x / d.getIntrinsicWidth()
                            + fw / d.getIntrinsicWidth(),
                    (double) y / d.getIntrinsicHeight()
                            + fh / d.getIntrinsicHeight());
        }
    }