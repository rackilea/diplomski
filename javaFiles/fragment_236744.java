public void onClick(View v) {
   new DownloadImageTask().execute("http://example.com/image.png");
}

private class DownloadImageTask extends AsyncTask {
   protected Bitmap doInBackground(String... urls) {
      return loadImageFromNetwork(urls[0]);
   }

   protected void onPostExecute(Bitmap result) {
      mImageView.setImageBitmap(result);
   }
}