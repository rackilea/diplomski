InputStream inputStream;
inputStream = crypto.getCipherInputStream(fileStream, entity);
ByteArrayOutputStream out = new ByteArrayOutputStream();
OutputStream outputStream = new FileOutputStream(mDecryptedFile);
BufferedInputStream bis = new BufferedInputStream(inputStream);
int mRead;
byte[] mBuffer = new byte[1024];
while ((mRead = bis.read(mBuffer)) != -1) {
   outputStream.write(mBuffer, 0, mRead);
    }
bis.close();
out.writeTo(outputStream);
inputStream.close();
outputStream.close();
out.close();