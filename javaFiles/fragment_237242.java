int primeSizeBytes = (ecParameterSpec.getCurve().getField().getFieldSize() + Byte.SIZE - 1) / Byte.SIZE;

if (ecPointBinary.length != 1 + 2 * primeSizeBytes) {
    // or think of your own exception
    throw new InvalidKeyException("EC point size invalid");
}

if (ecPointBinary[0] != 04) {
    throw new InvalidKeyException("EC uncompressed point indicator with byte value 04 missing");
}

byte[] x = Arrays.copyOfRange(ecPointBinary, 1, 1 + primeSizeBytes);
byte[] y = Arrays.copyOfRange(ecPointBinary, 1 + primeSizeBytes, 1 + 2 * primeSizeBytes);