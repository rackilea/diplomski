ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
Writer out = new OutputStreamWriter(byteOut, "UTF-8");  // Uses UTF-8 encoding
out.write("12");
out.write(10);
out.write(10);
out.close();

byte[] bytes = byteOut.toByteArray();