public void readPDFfromURL(String urlStr) throws IOException {
    URL myURL = new URL(urlStr);
    HttpURLConnection urlCon = (HttpURLConnection) myURL.openConnection();
    urlCon.setRequestProperty("Accept-Encoding", "gzip");
    urlCon.setRequestProperty("Content-Type", "application/pdf");
    urlCon.setRequestMethod("GET");
    urlCon.setDoInput(true);
    urlCon.connect();
    GZIPInputStream reader = new GZIPInputStream(urlCon.getInputStream());
    FileOutputStream fos = new FileOutputStream("document.pdf");
    byte[] buffer = new byte[1024];
    int len;
    while((len = reader.read(buffer)) != -1){
        fos.write(buffer, 0, len);
    }
    fos.close();
    reader.close();
}