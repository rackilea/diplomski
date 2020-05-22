fos= new FileOutputStream(cmrId+"/"+fileName);
InputStream is = sock.getInputStream());

int read = 0;
byte[] buf = new byte[1024];
while( (read = is.read(buf)) != -1) {
    fos.write(buf, 0, read);
}