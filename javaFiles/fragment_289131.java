private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
  ImageView bmImage;
  ProgressDialog pd;
  Context mContext;

  public DownloadImageTask(Context context,ImageView bmImage) {
      this.bmImage = bmImage;
      mContext = context;
  }

  public void onPreExecute() {
      pd = ProgressDialog.show(mContext, "dialog title","dialog message", true);   
  } 

  public void onPostExecute(Bitmap result) {
      pd.dismiss();
      if(result!=null)
          bmImage.setImageBitmap(result);
  }

  protected Bitmap doInBackground(String... urls) {
      String urldisplay = urls[0];
      Bitmap mIcon11 = null;
      try {
        InputStream in = new java.net.URL(urldisplay).openStream();
        mIcon11 = BitmapFactory.decodeStream(in);
      } catch (Exception e) {
          Log.e("Error", e.getMessage());
          e.printStackTrace();
      }
      return mIcon11;
  }
}