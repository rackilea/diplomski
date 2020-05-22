static boolean[] bits(final byte b) {
  return new boolean[] {
    (b &    1) != 0,
    (b &    2) != 0,
    (b &    4) != 0,
    (b &    8) != 0,
    (b & 0x10) != 0,
    (b & 0x20) != 0,
    (b & 0x40) != 0,
    (b & 0x80) != 0
  };
}