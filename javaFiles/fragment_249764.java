URL url = new URL("http://www.mediafire.com/listen/tok9j9s1hnogj1y/downloads/E0.wav");    
try (InputStream is = url.openStream()) {
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char)in);
    }
} catch (IOException exp) {
    exp.printStackTrace();
}