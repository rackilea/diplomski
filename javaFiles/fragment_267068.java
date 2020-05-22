// untested
final int BUFFER_SIZE = 23 * 1024;
InputStream is = ucon.getInputStream();
BufferedInputStream bis = new BufferedInputStream(is, BUFFER_SIZE);
FileOutputStream fos = new FileOutputStream(file);
byte[] baf = new byte[BUFFER_SIZE];
int actual = 0;
while (actual != -1) {
    fos.write(baf, 0, actual)
    actual = bis.read(baf, 0, BUFFER_SIZE);
}

fos.close();