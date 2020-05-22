AudioInputStream ais = ....;
ByteArrayOutputStream baos = new ByteArrayOutputStream();
int read;

while((read = ais.read()) != -1) {
    baos.write(read);
}

byte[] soundBytes = baos.toByteArray();