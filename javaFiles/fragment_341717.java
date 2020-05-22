public class StreamSplitter {
    private InputStream st;
    private Charset charset;

    /**
     * Construct new stream splitter.
     * @param st input stream
     * @param charset input stream charset
     */
    public StreamSplitter(InputStream st, Charset charset) {
        this.st = st;
        this.charset = charset;
    }

    // ... skip

    /**
     * Read stream until the specified marker is found. 
     * @param marker marker
     * @return 
     * @throws IOException
     */
    public String readUntil(String marker) throws IOException {
        StringBuilder res = new StringBuilder();
        if (!readUntil(marker, res)) {
                return null;
        }
        return res.toString();
    }

    /**
     * Read stream until the specified marker is found.
     * @param marker marker
     * @param res output 
     * @return <code>true</code> if marker is found, <code>false</code> if end of stream is occurred
     * @throws IOException
     */
    public boolean readUntil(String marker, StringBuilder res) throws IOException {
        byte[] markerBytes = marker.getBytes(charset);

        int b;
        int n = 0;

        while ((b = st.read()) != -1) {
            byte bb = (byte)b;

            if (markerBytes[n] == bb) {
                n++;
                if (n == markerBytes.length) {
                    return true;
                }
            }
            else {
                 if (n != 0 && res != null) {
                    for (int nn = 0; nn < n; nn++)
                        res.append((char)markerBytes[nn]);
                }

                if (res != null)
                    res.append((char)bb);
                n = 0;
            }
        }
        return false;
    }

    // ... skip 

}