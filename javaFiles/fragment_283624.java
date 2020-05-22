/** writes a BufferedImage of type TYPE_INT_ARGB to PNG using PNGJ */
public static void writeARGB(BufferedImage bi, OutputStream os) {
    if(bi.getType() != BufferedImage.TYPE_INT_ARGB) 
       throw new PngjException("This method expects  BufferedImage.TYPE_INT_ARGB" );
    ImageInfo imi = new ImageInfo(bi.getWidth(), bi.getHeight(), 8, true);
    PngWriter pngw = new PngWriter(os, imi);
    pngw.setCompLevel(9);// maximum compression, not critical usually
    pngw.setFilterType(FilterType.FILTER_AGGRESSIVE); // see what you prefer here
    DataBufferInt db =((DataBufferInt) bi.getRaster().getDataBuffer());
    SinglePixelPackedSampleModel samplemodel =  (SinglePixelPackedSampleModel) bi.getSampleModel();
    if(db.getNumBanks()!=1) 
        throw new PngjException("This method expects one bank");
    ImageLine line = new ImageLine(imi);
    for (int row = 0; row < imi.rows; row++) {
        int elem=samplemodel.getOffset(0,row);
        for (int col = 0,j=0; col < imi.cols; col++) {
            int sample = db.getElem(elem++);
            line.scanline[j++] =  (sample & 0xFF0000)>>16; // R
            line.scanline[j++] =  (sample & 0xFF00)>>8; // G
            line.scanline[j++] =  (sample & 0xFF); // B
            line.scanline[j++] =  (((sample & 0xFF000000)>>24)&0xFF); // A
        }
        pngw.writeRow(line, row);
    }
    pngw.end();
}