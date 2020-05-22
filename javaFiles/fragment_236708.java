FileInputStream fis = new FileInputStream("<path_to_pfx_file>");
ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
byte[] InBuffer = new byte[512];
int read = 0;
while ( (read = fis.read(InBuffer)) != -1 ) {
   outBuffer.write(InBuffer, 0, read);
}

BASE64Encoder encoder = new BASE64Encoder();
File fout = new File("<path_to_base64_pfx_file>");
FileOutputStream fos = new FileOutputStream(fout);

encoder.encodeBuffer(outBuffer.toByteArray(), fos);

fos.flush();
fos.close();