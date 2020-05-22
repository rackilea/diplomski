File file = new File(args[0]);
List<BufferedImage> images = new ArrayList<>();

try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream(1024 * 1024); // Use larger buffer for large images

    for (BufferedImage image : images) {
        buffer.reset();

        ImageIO.write(image, "JPEG", buffer); // Or PNG or any other format you like, really

        out.writeInt(buffer.size());
        buffer.writeTo(out);
        out.flush();
    }

    out.writeInt(-1); // EOF marker (alternatively, catch EOFException while reading)
}

// And, reading back:
try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
    int size;

    while ((size = in.readInt()) != -1) {
        byte[] buffer = new byte[size];
        in.readFully(buffer); // May be more efficient to create a FilterInputStream that counts bytes read, with local EOF after size

        images.add(ImageIO.read(new ByteArrayInputStream(buffer)));
    }
}