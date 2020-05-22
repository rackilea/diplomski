switch ( image.getType() )
    {
    case BufferedImage.TYPE_3BYTE_BGR : // Classical color images encoding.
        byte[] bb = ((DataBufferByte)image.getRaster().getDataBuffer()).getData() ;
        for (int y=0, pos=0 ; y < image.getHeight() ; y++)
            for (int x=0 ; x < image.getWidth() ; x++, pos+=3)
                {
                int b = bb[pos] & 0xFF ;
                int g = bb[pos+1] & 0xFF ;
                int r = bb[pos+2] & 0xFF ;
                }
        break ;
    }