byte b = (byte) 0x80; // force overflow, making -128
int i1 = b;
int i2 = Byte.toUnsignedInt(b);

System.out.println(String.format("%x", b)); // 80
System.out.println(String.format("%x", i1)); // ffffff80
System.out.println(String.format("%x", i2)); // 80