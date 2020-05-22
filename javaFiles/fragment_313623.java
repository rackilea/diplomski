private TIFFCompressor getTiffCompressor (TiffCompression compression, TIFFImageWriteParam writeParam, boolean usePredictor)
{
    int predictor = usePredictor 
            ? BaselineTIFFTagSet.PREDICTOR_HORIZONTAL_DIFFERENCING 
            : BaselineTIFFTagSet.PREDICTOR_NONE;

    switch (compression) 
    {
    case GROUP_3_FAX_ENCODING:
        return new TIFFT4Compressor();
    case GROUP_4_FAX_ENCODING:
        return new TIFFT6Compressor();
    case JPEG_COMPRESSION:
        return new TIFFJPEGCompressor(writeParam);
    case MACINTOSH_PACKBITS:
        return new TIFFPackBitsCompressor();
    case DEFLATE:
        return new TIFFDeflateCompressor(writeParam, predictor);
    case LZW:
        return new TIFFLZWCompressor(predictor);
    case MODIFIED_HUFFMAN:
        return new TIFFRLECompressor();
    case NO_COMPRESSION:
    case DEFAULT:
    default:
        return null;
    }
}