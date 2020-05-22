public static Mat imageToMat(Image image) {
    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    byte[] buffer = new byte[width * height * 4];

    PixelReader reader = image.getPixelReader();
    WritablePixelFormat<ByteBuffer> format = WritablePixelFormat.getByteBgraInstance();
    reader.getPixels(0, 0, width, height, format, buffer, 0, width * 4);

    Mat mat = new Mat(height, width, CvType.CV_8UC4);
    mat.put(0, 0, buffer);
    return mat;
}