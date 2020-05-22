public Bitmap getBitmap(String src)
{
    try {
        URL url = new URL(src);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap myBitmap = BitmapFactory.decodeStream(inputStream, null, options);
        return myBitmap;
    }
    catch (IOException e)
    {
        e.printStackTrace();
        return  null;
    }
}