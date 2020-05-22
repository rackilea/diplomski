byte[] buffer = new byte[1024];
int read;

while ((read = in.read(buffer)) != -1) {
    out.write(buffer, 0, read);
}
out.flush();
out.close();