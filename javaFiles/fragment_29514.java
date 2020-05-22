fileStream = new BufferedOutputStream(new FileOutputStream(mEncryptedFile));
OutputStream outputStream;
outputStream = crypto.getCipherOutputStream(fileStream, entity);
int read;
byte[] buffer = new byte[1024];
BufferedInputStream  bis = new BufferedInputStream(newFileInputStream(mPlainFile));
while ((read = bis.read(buffer)) != -1) {
       outputStream.write(buffer, 0, read);
    }
outputStream.close();
bis.close();