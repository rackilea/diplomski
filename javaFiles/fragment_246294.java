InputStream in = //from somewhere
OutputStream out = //to somewhere
byte[] buffer = new byte[8192];
int read = -1;
while ((read = in.read(buffer)) > -1) {
    out.write(buffer, 0, read);
}
out.close();
int.close();