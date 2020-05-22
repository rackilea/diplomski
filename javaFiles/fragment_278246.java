byte[] data = "nibbles".getBytes(StandardCharsets.US_ASCII);
for(byte b : data) {
    int high = (b & 0xf0) >> 4;
    int low = b & 0xf;
    System.out.format("%x%n", high);
    System.out.format("%x%n", low);
}