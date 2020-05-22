FileOutputStream outputStream = new FileOutputStream(new File(context.getCacheDir(), FILENAME), false);
OutputStream out = new BufferedOutputStream(outputStream);
byte[] loginBuffer = new byte[1024];
int byteRead = 0;
while((byteRead = in.read(loginBuffer)) != -1) {
    out.write(loginBuffer, 0, byteRead);
}
out.close();