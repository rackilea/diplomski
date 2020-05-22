private class LongOperation extends AsyncTask<String, Void, File> {

        @Override
        protected File doInBackground(String... params) {

            for (String imagePath : selectedImages) {
                File sourceImage = new File(imagePath); //returns the image File from model class to
                // be// moved.
                File destinationImage = new File(al_images.get(int_position).getDirectoryPath() +
                        File.separator + sourceImage.getName());

                try {
                    moveFile(sourceImage, destinationImage, true);
                    return destinationImage;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(File file) {
            super.onPostExecute(file);
            getBaseContext().sendBroadcast(new Intent(
            Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    fn_imagespath(); // Call method to fetch latest images.
                }
            }, 1000); // additional delay time of 1 sec to update media scanner
        }
    }