public static void main(String[] args) throws IOException {
    String urltext = "http://chart.apis.google.com/chart?cht=tx&chl=1+2%20\\frac{3}{4}";
    URL url = new URL(urltext);

    InputStream in = url.openStream();
    FileOutputStream out = new FileOutputStream("TheImage.png");

    byte[] buffer = new byte[8*1024];
    int readSize;
    while ( (readSize = in.read(buffer)) != -1) {
        out.write(buffer, 0, readSize);
    }
    out.close();
    in.close();
}