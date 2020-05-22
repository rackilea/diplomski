InputStream is = ... 
OutputStream os = ...

byte[] buf = new byte[2048];
int len;
while((len = is.read(buf)) != -1)
  os.write(buf, 0, len);

is.close();
os.close();