byte[] bytes = "some data".getBytes();

// Compute Adler-32 checksum
Checksum checksumEngine = new Adler32();
checksumEngine.update(bytes, 0, bytes.length);
long checksum = checksumEngine.getValue();

// Compute CRC-32 checksum
checksumEngine = new CRC32();
checksumEngine.update(bytes, 0, bytes.length);
checksum = checksumEngine.getValue();

// The checksum engine can be reused again for a different byte array by calling reset()
checksumEngine.reset();