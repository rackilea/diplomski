public InputStream download(String url) {
    URL myFileURL = null;
    InputStream is = null;
    try {
        myFileURL = new URL(url);
        is = myFileURL.openStream();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return is;
}