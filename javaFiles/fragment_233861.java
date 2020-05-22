byte[] bytes = ... // read from serial port

ShortBuffer buffer = ByteBuffer.wrap(bytes)
        .order(ByteOrder.BIG_ENDIAN) // Or LITTLE_ENDIAN depending on the spec of the card
        .asShortBuffer();            // Our data will be 16 bit unsigned shorts

// Create an image matching the pixel layout from the card
BufferedImage img = new BufferedImage(640, 480, BufferedImage.TYPE_USHORT_565_RGB);

// Get the pixel data from the image, and copy the data from the card into it
// (the cast here is safe, as we know this will be the case for TYPE_USHORT_565_RGB)
short[] data = ((DataBufferUShort) img.getRaster().getDataBuffer()).getData();
buffer.get(data);

// Finally, write it out as a proper BMP file
ImageIO.write(img, "BMP", new File("temp.bmp"));