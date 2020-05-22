final byte PACKET_TYPE = 3;
final byte PAD_BYTE = 0;
bBuffer.put(PACKET_TYPE);
bBuffer.put(PAD_BYTE);
bBuffer.put(PAD_BYTE);
bBuffer.put(PAD_BYTE);