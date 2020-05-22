InputStream in = new FileInputStream(new File("/path/to/src"));
OutputStream out = new FileOutputStream(new File("/path/to/dest"));
byte[] buffer = new byte[8192];
int len;
while ((len = in.read(buffer)) != -1) {
    out.write(buffer, 0, len);
}
in.close();
out.close();