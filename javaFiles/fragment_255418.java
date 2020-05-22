OutputStream os = new FileOutputStream(new File(...));

byte[] buffer = new byte[1024];
int read;

while ((read = stream.read(buffer) >= 0) {
   os.write(0, read, buffer);
}