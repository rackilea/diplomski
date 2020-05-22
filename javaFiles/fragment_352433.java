// public void testWrapBuffer_short_payload() {
// L296
int payloadLength = 100;
int messageLength = payloadLength + WebSocketHeader.MIN_HEADER_LENGTH_MASKED;

// L305
ByteBuffer srcBuffer = ByteBuffer.allocate(payloadLength);
ByteBuffer dstBuffer = ByteBuffer.allocate(messageLength);

// And others functions testWrapBuffer_xxxx_payload