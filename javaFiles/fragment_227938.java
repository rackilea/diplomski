byte[] buf = new byte[1<<12];
InputStream in = urlConnection.getInputStream();
int read = -1;

while ((read = in.read(buf) != -1) {
    System.out.write(buf, 0, read);
}