class Bits {
  private byte value;

  public Bits() { this(0x0); }
  public Bits(byte initial) { value = initial; }

  public boolean isSet(int bit) {
    return (value & (1<<bit)) != 0;
  }

  public void set(int bit) { /* ... */ }
  public void unset(int bit) { /* ... */ }

  public byte toByte() { return value; }
}