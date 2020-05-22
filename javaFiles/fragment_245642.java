public void writeTargaImageTo(Path file,
                              BufferedImage image)
throws IOException {
    try (WritableByteChannel channel = Files.newByteChannel(file,
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING)) {

        writeTargaImageTo(channel, image);
    }
}

public void writeTargaImageTo(WritableByteChannel out,
                              BufferedImage image)
throws IOException {

    short originX = (short) image.getMinX();
    short originY = (short) image.getMinY();
    short width = (short) image.getWidth();
    short height = (short) image.getHeight();

    ByteBuffer header = ByteBuffer.allocate(18);
    header.order(ByteOrder.LITTLE_ENDIAN);

    header.put((byte) 0);       // Length of string Identification
    header.put((byte) 0);       // No colormap
    header.put((byte) 10);      // Image type: RLE compressed RGB
    header.putShort((short) 0); // Colormap type (irrelevant, no colormap)
    header.putShort((short) 0); // Colormap first index (irrelevant)
    header.put((byte) 0);       // Colormap bits per entry (irrelevant)
    header.putShort(originX);   // Origin x coordinate
    header.putShort(originY);   // Origin y coordinate
    header.putShort(width);     // Image width
    header.putShort(height);    // Image height
    header.put((byte) 32);      // Bits per pixel
    header.put((byte) (
        8                       // Number of alpha bits
        | (1 << 5)              // Origin is upper left
    ));

    header.flip();
    out.write(header);

    int lastPixel = 0;
    int runLength = 0;

    ByteBuffer rlePacket = ByteBuffer.allocate(1 + 4);
    ByteBuffer rawPacket = ByteBuffer.allocate(1 + 128 * 4);
    rlePacket.order(ByteOrder.LITTLE_ENDIAN);
    rawPacket.order(ByteOrder.LITTLE_ENDIAN);

    rawPacket.put((byte) 0);  // placeholder for header

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            int pixel = image.getRGB(originX + x, originY + y);

            if (x == 0 && y == 0) {
                lastPixel = pixel;
                runLength = 1;
                rawPacket.putInt(pixel);
                continue;
            }

            boolean finalPixel = (x == width - 1 && y == height - 1);

            if (finalPixel) {
                if (pixel == lastPixel) {
                    runLength++;
                } else {
                    rawPacket.putInt(pixel);
                }
            }

            if (runLength >= 128 ||
                (runLength > 1 &&
                    (finalPixel || pixel != lastPixel))) {

                rlePacket.clear();

                rlePacket.put((byte) (0x80 | (runLength - 1)));
                rlePacket.putInt(lastPixel);

                rlePacket.flip();
                out.write(rlePacket);

                runLength = 0;
                rawPacket.clear();
                rawPacket.put((byte) 0);  // placeholder for header
            }

            if (!rawPacket.hasRemaining() ||
                (rawPacket.position() > 1 &&
                    (finalPixel || pixel == lastPixel))) {

                // "Forget" duplicated pixel, since it will be in RLE
                if (!finalPixel) {
                    rawPacket.position(rawPacket.position() - 4);
                }

                int rawPixelCount = (rawPacket.position() - 1) / 4;
                if (rawPixelCount > 0) {
                    rawPacket.put(0, (byte) (rawPixelCount - 1));
                    rawPacket.flip();
                    out.write(rawPacket);
                }

                runLength = 1;
                rawPacket.clear();
                rawPacket.put((byte) 0);  // placeholder for header
            }

            if (!finalPixel) {
                if (pixel == lastPixel) {
                    runLength++;
                } else {
                    rawPacket.putInt(pixel);
                    lastPixel = pixel;
                }
            }
        }
    }
}