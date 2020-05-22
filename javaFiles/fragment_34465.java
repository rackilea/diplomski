int[] buffer = /* pixels */;

ColorModel model = new ComponentColorModel(
   ColorSpace.getInstance(ColorSpace.CS_GRAY), new int[] { 16 }, 
   false, true, Transparency.OPAQUE, DataBuffer.TYPE_USHORT);

Image image = Toolkit.getDefaultToolkit().createImage(
   new MemoryImageSource(VERTICAL_PIXELS, HORIZONTAL_PIXELS, 
                         model, buffer, 0, VERTICAL_PIXELS));