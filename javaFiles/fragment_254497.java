public void copy (InputStream in , File file, int length) throws IOException {
    FileOutputStream fos = new FileOutputStream(file);
    int cnt = 0;
    byte[] buffer = new byte[1024 * 8];
    while(cnt < length)
    { 
        int n = in.read(buffer);
        fos.write(buffer, 0, n);
        cnt += n;
    }
    fos.flush();
    fos.close();
}