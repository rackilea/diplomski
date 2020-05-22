int cidrMask = 23;
long bits = 0;
bits = 0xffffffff ^ (1 << 32 - cidrMask) - 1;
String mask = String.format("%d.%d.%d.%d", (bits & 0x0000000000ff000000L) >> 24, (bits & 0x0000000000ff0000) >> 16, (bits & 0x0000000000ff00) >> 8, bits & 0xff);

>>255.255.254.0