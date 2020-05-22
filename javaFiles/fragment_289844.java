/** Variables **/
 public static AndroidHttpClient httpclient = null;


/** Public Functions **/
public static Bitmap getBitmap(String url) {
    Bitmap bm = null;
    try {
        URL aURL = new URL(url);
        URLConnection conn = aURL.openConnection();
        conn.connect();
        InputStream is = conn.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        bm = BitmapFactory.decodeStream(new FlushedInputStream(is));
        bis.close();
        is.close();
    } 
    catch (Exception e) {
        e.printStackTrace();
    } 
    finally {
        if (httpclient != null) {
            httpclient.close();
        }
    }
    return bm;
}

/** Classes **/
private static class FlushedInputStream extends FilterInputStream {
    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public long skip(long n) throws IOException {
        long totalBytesSkipped = 0L;
        while (totalBytesSkipped < n) {
            long bytesSkipped = in.skip(n - totalBytesSkipped);
            if (bytesSkipped == 0L) {
                int b = read();
                if (b < 0) {
                    break; // we reached EOF
                } else {
                    bytesSkipped = 1; // we read one byte
                }
            }
            totalBytesSkipped += bytesSkipped;
        }
        return totalBytesSkipped;
    }
}