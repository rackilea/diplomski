Optional<byte[]> hash = strings.stream()
        .map(s -> Hashing.md5().hashString(s, Charset.defaultCharset()))
        .map(HashCode::asBytes)
        .reduce((left, right) -> xor(left, right));


static byte[] xor(byte[] left, byte[] right) {
    if(left.length != right.length) {
        throw new IllegalArgumentException();
    }
    byte[] result = new byte[left.length];
    for(int i=0; i < result.length; i++) {
        result[i] = (byte) (left[i] ^ right[i]);
    }
    return result;
}