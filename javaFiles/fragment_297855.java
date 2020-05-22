URL url = getClassLoader().getResource("com/test/io/test.txt");
FileOutputStream output = new FileOutputStream("test.txt");
InputStream input = url.openStream();
byte [] buffer = new byte[4096];
int bytesRead = input.read(buffer);
while (bytesRead != -1) {
    output.write(buffer, 0, bytesRead);
    bytesRead = input.read(buffer);
}
output.close();
input.close();