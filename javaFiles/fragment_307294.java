public static int getImageType(BufferedImage img) {
    int imageType = img.getType();
    switch (imageType) {
        case BufferedImage.TYPE_CUSTOM:
            if (img.getAlphaRaster() != null) {
                imageType = BufferedImage.TYPE_INT_ARGB_PRE;
            }
            else {
                imageType = BufferedImage.TYPE_INT_RGB;
            }
            break;
        case BufferedImage.TYPE_BYTE_BINARY:
            // Handle both BYTE_BINARY (1-4 bit/pixel) and BYTE_INDEXED (8 bit/pixel)
        case BufferedImage.TYPE_BYTE_INDEXED:
            if (img.getColorModel().hasAlpha()) {
                imageType = BufferedImage.TYPE_INT_ARGB_PRE;
            }
            else {
                // Handle non-alpha variant
                imageType = BufferedImage.TYPE_INT_RGB;
            }
            break;
    }

    return imageType;
}