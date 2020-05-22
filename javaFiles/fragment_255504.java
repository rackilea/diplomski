buffer.put((byte)(type & 0xFF));
 buffer.put((byte)(flags & 0xFF));
 buffer.putShort((short)(len & 0xFFFF));
 buffer.putInt((int)(sequenceN & 0xFFFFFFFF));
 buffer.putShort((short)(startIdx & 0xFFFF));
 buffer.putShort((short)(endIdx & 0xFFFF));