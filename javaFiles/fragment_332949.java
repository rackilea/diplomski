private LoadHiResImageTask loadHiResImageTask = new LoadHiResImageTask();

private class LoadHiResImageTask extends AsyncTask<Double, Void, Bitmap> {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */
        protected Bitmap doInBackground(Double... numbers) {
            return getCroppedBitmap(
                    // You will have to change first parameter here!
                    Uri.parse(imagesToCrop[0]),
                    numbers[0].intValue(), numbers[1].intValue(),
                    numbers[2], numbers[3], numbers[4], numbers[5]);
        }

        /** The system calls this to perform work in the UI thread and delivers
         * the result from doInBackground() */
        protected void onPostExecute(Bitmap result) {
            ImageView hiresImage = (ImageView) findViewById(R.id.hiresImage);
            hiresImage.setImageBitmap(result);
            hiresImage.postInvalidate();
        }
    }