LZ4Factory factory = LZ4Factory.fastestInstance();

byte[] data = "12345345234572".getBytes("UTF-8");
final int decompressedLength = data.length;

// compress data
LZ4Compressor compressor = factory.fastCompressor();
int maxCompressedLength = compressor.maxCompressedLength(decompressedLength);
byte[] compressed = new byte[maxCompressedLength];
int compressedLength = compressor.compress(data, 0, decompressedLength, compressed, 0, maxCompressedLength);

// decompress data
// - method 1: when the decompressed length is known
LZ4FastDecompressor decompressor = factory.fastDecompressor();
byte[] restored = new byte[decompressedLength];
int compressedLength2 = decompressor.decompress(compressed, 0, restored, 0, decompressedLength);
// compressedLength == compressedLength2

// - method 2: when the compressed length is known (a little slower)
// the destination buffer needs to be over-sized
LZ4SafeDecompressor decompressor2 = factory.safeDecompressor();
int decompressedLength2 = decompressor2.decompress(compressed, 0, compressedLength, restored, 0);
// decompressedLength == decompressedLength2