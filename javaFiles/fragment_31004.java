public static IplImage createFrom(BufferedImage image) {
    return createFrom(image, 1.0);
}

public static IplImage createFrom(BufferedImage image, double gamma) {
    return createFrom(image, gamma, false);
}

public static IplImage createFrom(BufferedImage image, double gamma, boolean flipChannels) {
    if (image == null) {
        return null;
    }
    SampleModel sm = image.getSampleModel();
    int depth = 0, numChannels = sm.getNumBands();
    switch (image.getType()) {
        case BufferedImage.TYPE_INT_RGB:
        case BufferedImage.TYPE_INT_ARGB:
        case BufferedImage.TYPE_INT_ARGB_PRE:
        case BufferedImage.TYPE_INT_BGR:
            depth = IPL_DEPTH_8U;
            numChannels = 4;
            break;
    }
    if (depth == 0 || numChannels == 0) {
        switch (sm.getDataType()) {
            case DataBuffer.TYPE_BYTE:   depth = IPL_DEPTH_8U;  break;
            case DataBuffer.TYPE_USHORT: depth = IPL_DEPTH_16U; break;
            case DataBuffer.TYPE_SHORT:  depth = IPL_DEPTH_16S; break;
            case DataBuffer.TYPE_INT:    depth = IPL_DEPTH_32S; break;
            case DataBuffer.TYPE_FLOAT:  depth = IPL_DEPTH_32F; break;
            case DataBuffer.TYPE_DOUBLE: depth = IPL_DEPTH_64F; break;
            default: assert false;
        }
    }
    IplImage i = create(image.getWidth(), image.getHeight(), depth, numChannels);
    i.copyFrom(image, gamma, flipChannels);
    return i;
}