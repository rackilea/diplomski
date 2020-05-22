WritableRaster wr = image.getRaster() ;
for (int y=0, nb=0 ; y < image.getHeight() ; y++)
    for (int x=0 ; x < image.getWidth() ; x++, nb++)
        {
        int r = wr.getSample(x, y, 0) ; // You just give the channel number, no need to handle the encoding.
        int g = wr.getSample(x, y, 1) ;
        int b = wr.getSample(x, y, 2) ;
        }