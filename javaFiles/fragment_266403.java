public class CMYKTest {

    public static final String JAVAX_IMAGEIO_JPEG_IMAGE_1_0 = "javax_imageio_jpeg_image_1.0";

    public static void main(String[] args) throws IOException {
        // I'm using my own TwelveMonkeys ImageIO library for this, 
        // but I think you can use the one you used above, like:
        // ColorSpace cmykCS = ColorSpaces.getDeviceCMYKColorSpace()
        ColorSpace cmykCS = ColorSpaces.getColorSpace(ColorSpaces.CS_GENERIC_CMYK);

        // Create CMYK color model, raster and image
        ColorModel colorModel = new ComponentColorModel(cmykCS, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        BufferedImage image = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(100, 100), colorModel.isAlphaPremultiplied(), null);

        // Paint some sample rectangles on it
        Graphics2D g = image.createGraphics();
        try {
            g.setColor(new Color(cmykCS, new float[] {0, 0, 0, 0}, 1.0f)); // All 0 (White)
            g.fillRect(0, 0, 25, 50);
            g.setColor(new Color(cmykCS, new float[] {0, 0, 0, 1}, 1.0f)); // Key (Black)
            g.fillRect(25, 0, 25, 50);
            g.setColor(new Color(cmykCS, new float[] {1, 0, 0, 0}, 1.0f)); // Cyan
            g.fillRect(50, 0, 50, 50);
            g.setColor(new Color(cmykCS, new float[] {0, 1, 0, 0}, 1.0f)); // Magenta
            g.fillRect(0, 50, 50, 50);
            g.setColor(new Color(cmykCS, new float[] {0, 0, 1, 0}, 1.0f)); // Yellow
            g.fillRect(50, 50, 50, 50);
        }
        finally {
            g.dispose();
        }

        // Write it as a JPEG, using ImageIO    
        try (ImageOutputStream stream = ImageIO.createImageOutputStream(new File("cmyk.jpg"))) {
            ImageWriter writer = ImageIO.getImageWritersByFormatName("JPEG").next();
            writer.setOutput(stream);

            // We need to massage the image metadata a little to be able to write CMYK
            ImageWriteParam param = writer.getDefaultWriteParam();
            IIOMetadata metadata = writer.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(image), param);

            IIOMetadataNode jpegMeta = new IIOMetadataNode(JAVAX_IMAGEIO_JPEG_IMAGE_1_0);
            jpegMeta.appendChild(new IIOMetadataNode("JPEGVariety")); // Just leave as default

            IIOMetadataNode markerSequence = new IIOMetadataNode("markerSequence");
            jpegMeta.appendChild(markerSequence);

            // The APP14 "Adobe" marker acts as a trigger for decoders, to
            // specify 4 channels as CMYK or YCCK (instead of RGBA or YCCA).
            IIOMetadataNode app14Adobe = new IIOMetadataNode("app14Adobe");
            app14Adobe.setAttribute("transform", "0"); // 0 means "unknown"
            markerSequence.appendChild(app14Adobe);

            // You could also append an ICC profile as part of the JPEG metadata
            // if you feel adventurous...

            // Merge with metadata from the writer
            metadata.mergeTree(JAVAX_IMAGEIO_JPEG_IMAGE_1_0, jpegMeta);

            // Also, we need to massage the raster a little, as CMYK data is
            // written in "inverse" form. 
            // We could use image.getRaster() here to get better performance
            // if you don't mind the image being inverted in memory too. 
            // image.getData() creates a copy, and is safe from this side effect.
            Raster raster = image.getData(); 
            byte[] data = ((DataBufferByte) raster.getDataBuffer()).getData();
            // Inverse the pixel data
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (255 - data[i]);
            }

            // Finally, write it all
            writer.write(null, new IIOImage(raster, null, metadata), param);
        }
    }
}