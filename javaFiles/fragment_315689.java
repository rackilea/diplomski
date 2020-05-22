private static int decompressedLength;
private static LZ4Factory factory = LZ4Factory.fastestInstance();
private static LZ4Compressor compressor = factory.fastCompressor();

public static byte[] compress(byte[] src, int srcLen) {
    decompressedLength = srcLen;
    int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
    byte[] compressed = new byte[maxCompressedLength];
    int compressLen = compressor.compress(src, 0, decompressedLength, compressed, 0, maxCompressedLength);
    byte[] finalCompressedArray = Arrays.copyOf(compressed, compressLen);
    return finalCompressedArray;
}