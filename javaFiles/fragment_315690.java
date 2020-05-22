private static LZ4FastDecompressor decompressor = factory.fastDecompressor();

public static byte[] decompress(byte[] finalCompressedArray, int decompressedLength) {
    byte[] restored = new byte[decompressedLength];
    restored = decompressor.decompress(finalCompressedArray, decompressedLength);
    return restored;
}