int segmentSize = 6;
String[] segments = new String[msg.length() / segmentSize + 1];

for (int i = 0; i < msg.length(); i += segmentSize) {
    // ensure we don't try to access out of bounds indexes
    int lastIndex = Math.min(msg.length(), i+segmentSize);
    int segmentNumber = i/segmentSize;
    segments[segmentNumber] = msg.substring(i, lastIndex);
}