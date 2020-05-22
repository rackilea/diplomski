public static BufferedImage desaturate(BufferedImage source) {
    ColorConvertOp colorConvert = 
        new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
    colorConvert.filter(source, source);

    return source;
}