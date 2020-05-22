try {
    String base = "http://www.somethingxxxxx.com/";
    String toEncode = "adiós";
    String myEncodedUrl = base + URLEncoder.encode( toEncode, "UTF-8" );
    URLConnection yc = new URL(myEncodedUrl).openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(
                                            yc.getInputStream()));
} catch ( UnsupportedEncodingException exc ) {
   exc.printStackTrace();
} catch ( IOException exc ) {
   exc.printStackTrace();
}