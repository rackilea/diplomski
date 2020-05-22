try {
    jWriteParam.setCompressionMode(_compression != TiffCompression.NO_COMPRESSION 
                  ? ImageWriteParam.MODE_EXPLICIT : ImageWriteParam.MODE_DISABLED);

    if (_compression != TiffCompression.NO_COMPRESSION) {
        // this code corrects the compression if, say, the client code asked for
        // CCITT but the actual image pixel format was CMYK or some other non-1 bit
        // image type.
        TiffCompression mode = recastToValidCompression(_compression, pf);
        jWriteParam.setCompressionType(getCompressionType(mode));
        TIFFCompressor compressor = getTiffCompressor(mode, jWriteParam, shouldUsePredictor(pf));
        jWriteParam.setTIFFCompressor(compressor);
        if (_compression == TiffCompression.JPEG_COMPRESSION) {
            // Java supports setting to 1.0 (ie 100), but it will not actually do lossless (maybe)
            if (_jpegQuality == 100 && !jWriteParam.isCompressionLossless())
                continue;
            jWriteParam.setCompressionQuality(toJavaJpegQuality());
        }
    }
}
catch (UnsupportedOperationException e)
{
    // this shouldn't get here, but you should consider what to do if it does.
    // set a default? throw?
}