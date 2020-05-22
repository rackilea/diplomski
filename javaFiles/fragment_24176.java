class example_bitfield {
  byte a;
  byte b;
  byte c;
  short d;

  public void fromArray(byte[] m) {
    byte b0=m[0];
    byte b1=m[1];
    a=b0>>>7;
    b=(b0>>6)&1;
    c=(b0>>4)&3;
    d=(b0&0xF<<6)|(b1>>>2);
  }
  public void toArray(byte[] m) {
    m[0]=(a<<7)|(b<<6)|(c<<4)|(d>>>6);
    m[1]=(d&0x3F)<<2;
  }
}