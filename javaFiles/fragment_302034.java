Process p = Runtime.getRuntime().exec("openssl enc -base64 -d");
// Process p = Runtime.getRuntime().exec("base64 -d");    // the base64 command also works
BufferedWriter toChild = new BufferedWriter(
                             new OutputStreamWriter(p.getOutputStream()));
toChild.write(Base64String + "\n");
toChild.close();