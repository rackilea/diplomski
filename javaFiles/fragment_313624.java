private String getCompressionType (TiffCompression compression)
{
    switch (compression)
    {
    case GROUP_3_FAX_ENCODING:
        return "CCITT T.4";
    case GROUP_4_FAX_ENCODING:
        return "CCITT T.6";
    case JPEG_COMPRESSION:
        return "JPEG";
    case MACINTOSH_PACKBITS:
        return "PackBits";
    case DEFLATE:
        return "Deflate";
    case LZW:
        return "LZW";
    case MODIFIED_HUFFMAN:
        return "CCITT RLE";
    case NO_COMPRESSION:
    case DEFAULT:
    default:
        return null;
    }
}