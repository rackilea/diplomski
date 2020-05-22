try {
  URL  url = new URL("ftp://user:pass@ftp.xyz.com/testjar/2014-03-06-p.txt;type=i");
  URLConnection urlc = url.openConnection();
  OutputStream os = urlc.getOutputStream(); // To upload
  OutputStream buffer = new BufferedOutputStream(os);
  PrintStream output = new PrintStream(buffer);
  output.print("hiiiii");

} catch (IOException ex) {
    ex.printStackTrace();
} finally {

  output.close();
  buffer.close();
  os.close();
}