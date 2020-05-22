// Simply start by defining the fileoutputstream
FileOutputStream fos = new FileOutputStream(file);
int red = 0;
// This size can be changed
byte[] buf = new byte[1024];
while ((red = bis.read(buf)) != -1) {
    // And directly write to it.
    fos.write(buf, 0, red);
}
long endTime = System.currentTimeMillis(); //maybe
// Flush after, as this may trigger a commit to disk.
fos.flush();
fos.close();