MultipartFile file = model.getImageFile();
inputStream = file.getInputStream();
outputStream = new FileOutputStream(fullyFileName);

int readBytes = 0;
byte[] buffer = new byte[1024 * 50];
while ((readBytes = inputStream.read(buffer, 0, 1024 * 50)) != -1) {
    outputStream.write(buffer, 0, readBytes);
}