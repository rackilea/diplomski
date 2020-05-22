class LoadImageTask extends AsyncTask<String, Void, Drawable > {
    public LoadImageTask(ImageView iv)
    {
        imageView = iv;
    }
    ImageView imageView;
    protected Drawable doInBackground(String... urls) {
        try {
            URLConnection connection = new URL(urls[0]).openConnection();
            connection.connect();
            InputStream is = (InputStream) connection.getContent();
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Drawable drawable) {
        if(drawable != null)
            imageView.setImageDrawable(drawable);
    }
}