oos.writeObject(imageFile);
try (InputStream stream =
    new BufferedInputStream(new FileInputStream(imageFile))) {

    stream.transferTo(oos);
}