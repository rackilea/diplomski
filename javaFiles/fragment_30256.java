String filename = "jEEDL.png";

    PlanarImage image = PlanarImage.wrapRenderedImage(JAI.create("fileload", filename));

    LookupTableJAI lut = new LookupTableJAI(new byte[][] {{(byte)0x00, (byte)0xff}, {(byte)0x00, (byte)0xff}, {(byte)0x00, (byte)0xff}});
    ImageLayout layout = new ImageLayout();
    byte[] map = new byte[] {(byte)0x00, (byte)0xff};
    ColorModel cm = new IndexColorModel(1, 2, map, map, map);
    layout.setColorModel(cm);
    SampleModel sm = new MultiPixelPackedSampleModel(DataBuffer.TYPE_BYTE,
            image.getWidth(),
            image.getHeight(),
            1);
    layout.setSampleModel(sm);
    RenderingHints hints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, layout);
    PlanarImage op = ErrorDiffusionDescriptor.create(image, lut, KernelJAI.ERROR_FILTER_FLOYD_STEINBERG, hints);

    BufferedImage dst  = op.getAsBufferedImage();

    JAI.create("filestore", dst, "jEEDL.bmp", "BMP");