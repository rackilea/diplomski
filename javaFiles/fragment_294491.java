File imageFile = (File) ois.readObject();
long length = imageFile.length();

Path imagePath = Files.createTempFile(null, imageFile.getName());
try (FileChannel imageChannel = FileChannel.open(imagePath, 
    StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

    imageChannel.transferFrom(Channels.newChannel(ois), 0, length);
}

Image avatar = new Image(imagePath.toUri().toString());