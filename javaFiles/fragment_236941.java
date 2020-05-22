public IconImage(IconDirEntry entry)
{
    this.entry = entry;
    try
    {
        final ByteArrayInputStream bais = new ByteArrayInputStream(entry.getImageData());
        bais.mark(4);
        iis = ImageIO.createImageInputStream(bais);
        iis.setByteOrder(java.nio.ByteOrder.LITTLE_ENDIAN);
        biSize = iis.readInt();
        if(biSize == 0x474e5089) { //PNG instead of tagBITMAPINFOHEADER)
            bais.reset();
            BufferedImage bi = ImageIO.read(bais);
            System.out.println("read embedded PNG "+bi.getWidth()+" x "+bi.getHeight());
            return;
        }
…