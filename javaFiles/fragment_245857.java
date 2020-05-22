byte[2] out;
int x;
out[0] = x & 0xff;
out[1] = x >> 8;

x = out[0] + (out[1] << 8);