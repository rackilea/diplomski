private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeInt(imageSelection.size()); // how many images are serialized?

    for (BufferedImage eachImage : imageSelection) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(eachImage, "jpg", buffer);

        out.writeInt(buffer.size()); // Prepend image with byte count
        buffer.writeTo(out);         // Write image
    }
}

private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();

    int imageCount = in.readInt();
    imageSelection = new ArrayList<BufferedImage>(imageCount);
    for (int i = 0; i < imageCount; i++) {
        int size = in.readInt(); // Read byte count

        byte[] buffer = new byte[size];
        in.readFully(buffer); // Make sure you read all bytes of the image

        imageSelection.add(ImageIO.read(new ByteArrayInputStream(buffer)));
    }
}