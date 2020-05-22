public static void main(String[] args) throws IOException   {
        String text ="hello hi how are you";
         URL url = new URL("http://translate.google.com/translate_tts?" + "q="
                 + text.replace(" ", "%20") + "&tl=" + "en");
 URLConnection urlConn = url.openConnection();
 urlConn.addRequestProperty("User-Agent",
                 "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
  InputStream audioSrc = urlConn.getInputStream();

  DataInputStream read = new DataInputStream(audioSrc);
  OutputStream outstream = new FileOutputStream(new File("src/savedSound.wav"));
  byte[] bArr = new byte[audioSrc.available()];
  int len;
  while ((len = read.read(bArr)) > 0) {
          outstream.write(bArr, 0, len);                    
  }
  outstream.close();   
    }