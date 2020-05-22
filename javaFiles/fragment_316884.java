int cL = Integer.valueOf(contentLength);
byte[]  buffer      = new byte[cL];
String  postData    = "";

System.out.println("Reading "+ cL + "bytes");
in.read(buffer, 0, cL);
postData = new String(buffer, 0, buffer.length);
System.out.println(postData);