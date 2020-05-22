try {
    MagickImage image = new MagickImage(new ImageInfo(baseName + fileName));

    if (!image.rgbTransformImage(ColorspaceType.CMYKColorspace))
         throw new Exception("Couldn't convert image color space");

    ...
} catch (MagickException e) {
    ...
}