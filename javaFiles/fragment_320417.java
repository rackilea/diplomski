int a = 0x7FFFFFFF;
int b = 0x10000000;
long x;

// Method one
x = (a & 0xFFFFFFFFL) << 32 | b;

// Method two
x = (((long)a) << 32) | b;