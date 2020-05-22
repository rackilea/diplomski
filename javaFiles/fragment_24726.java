private static byte[] toByteArray(UUID uuid) {
  long mostSigBits = uuid.getMostSignificantBits();
  return ByteBuffer.allocate(16)
      .order(ByteOrder.LITTLE_ENDIAN)
      .putInt((int) (mostSigBits >> 32))
      .putShort((short) (((int) mostSigBits) >> 16))
      .putShort((short) mostSigBits)
      .order(ByteOrder.BIG_ENDIAN)
      .putLong(uuid.getLeastSignificantBits())
      .array();
}