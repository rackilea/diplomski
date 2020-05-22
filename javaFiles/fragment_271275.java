public static BufferedImage createAwtImage(Mat mat) {

    int type = 0;
    if (mat.channels() == 1) {
        type = BufferedImage.TYPE_BYTE_GRAY;
    } else if (mat.channels() == 3) {
        type = BufferedImage.TYPE_3BYTE_BGR;
    } else {
        return null;
    }

    BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
    WritableRaster raster = image.getRaster();
    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
    byte[] data = dataBuffer.getData();
    mat.get(0, 0, data);

    return image;
}