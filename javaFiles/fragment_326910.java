ByteBuffer buffer = ByteBuffer.allocate(54);
    buffer.putInt(bfSize);
    buffer.putShort(bfReserved1);
    buffer.putShort(bfReserved2);
    buffer.putInt(bfOfBytes);
    buffer.putInt(biSize);
    buffer.putInt(biWidth);
    buffer.putInt(biHeight);
    buffer.putShort(biPlanes);
    buffer.putShort(biBitCount);
    buffer.putInt(biSizeImage);
    buffer.putInt(biXPelsPerMeter);
    buffer.putInt(biYPelsPerMeter);

    buffer.order(ByteOrder.LITTLE_ENDIAN);
    buffer.flip();