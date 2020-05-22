byte[] buffer = new byte[BUFFER_SIZE];
int bytesRead = -1;
while ((bytesRead = in.read(buffer)) != -1) {
    out.write(buffer, 0, bytesRead);
}
out.flush();