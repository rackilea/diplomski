public byte[] download(URL url) throws IOException {
    URLConnection uc = url.openConnection();
    int len = uc.getContentLength();
    InputStream is = new BufferedInputStream(uc.getInputStream());
    try {
        byte[] data = new byte[len];
        int offset = 0;
        while (offset < len) {
            int read = is.read(data, offset, data.length - offset);
            if (read < 0) {
                break;
            }
          offset += read;
        }
        if (offset < len) {
            throw new IOException(
                String.format("Read %d bytes; expected %d", offset, len));
        }
        return data;
    } finally {
        is.close();
    }
}