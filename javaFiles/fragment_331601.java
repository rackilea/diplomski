AudioInputStream ais = ....;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int bytesRead = 0;

while((bytesRead = ais.read(buffer)) != -1) {
    baos.write(buffer, 0, bytesRead);
}

byte[] soundBytes = baos.toByteArray();