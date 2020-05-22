public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
ImageView bmImage;

public DownloadImage(ImageView bmImage) {
    this.bmImage = (ImageView ) bmImage;
}

protected Bitmap doInBackground(String... urls) {
    String urldisplay = urls[0];
    Bitmap mIcon11 = null;
    try {
        InputStream in = new java.net.URL(urldisplay).openStream();
        mIcon11 = BitmapFactory.decodeStream(in);
    } catch (Exception e) {
        Log.d("Error", e.getStackTrace().toString());

    }
    return mIcon11;
}

protected void onPostExecute(Bitmap result) {
    bmImage.setImageBitmap(result);
}
}