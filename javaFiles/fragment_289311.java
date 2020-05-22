// Why is there no method to give this guaranteed charset
// without "risk" of exceptions? Grr.
Charset utf8 = Charset.forName("UTF-8");     
BufferedReader input = new BufferedReader(
                           new InputStreamReader(
                               new FileInputStream("filename"),
                               utf8));