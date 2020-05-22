response.setContentType("binary/octet-stream");
InputStream is = request.getInputStream();
BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:\\Files\\copyFile.xml")));
byte[] buf = new byte[4096];
for (int nChunk = is.read(buf); nChunk!=-1; nChunk = is.read(buf)) {
   bos.write(buf, 0, nChunk);
}
bos.flush();
bos.close();