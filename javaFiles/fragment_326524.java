static final String FILE_URL = "http://www.example.com/speedtest/file.bin";
static final long FILE_SIZE = 5 * 1024 * 8; // 5MB in Kilobits

long mStart, mEnd;
Context mContext;
URL mUrl = new URL(FILE_URL);
HttpURLConnection mCon = (HttpURLConnection)mUrl.openConnection();
mCon.setChunkedStreamingMode(0);

if(mCon.getResponseCode() == HttpURLConnection.HTTP_OK) {
    mStart = new Date().getTime();

    InputStream input = mCon.getInputStream();
    File f = new File(mContext.getDir("temp", Context.MODE_PRIVATE), "file.bin");
    FileOutputStream fo = new FileOutputStream(f);
    int read_len = 0;

    while((read_len = input.read(buffer)) > 0) {
        fo.write(buffer, 0, read_len);
    }
    fo.close();
    mEnd = new Date().getTime();
    mCon.disconnect();

    return FILE_SIZE / ((mEnd - mStart) / 1000);
}