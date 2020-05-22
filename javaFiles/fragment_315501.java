byte[] buffer = new byte[4096];
ByteArrayOutputStream out = new ByteArrayOutputStream();
InputStream is;
//
//some setup code
//
while (is.available() > 0) {
   int len = is.read(buffer);
   out.write(buffer, 0, len);
}
String result = out.toString("UTF-8"); // for instance