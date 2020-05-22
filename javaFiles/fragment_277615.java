byte[] bytes = ByteBuffer.allocate(8).putLong(someLong).array();
for (int left = 0, right = bytes.length - 1; left < right; ++left, --right) {
    byte temp = bytes[left]; 
    bytes[left]  = bytes[right]; 
    bytes[right] = temp;
}