ByteBuffer bb = ByteBuffer.allocate(4);
// y = number
// i  = * ( long * ) &y; // assuming long is 32-bit, not long long
bb.putFloat(0, number);
int i = bb.getInt(0);
// i  = 0x5f3759df - ( i >> 1 );
i  = 0x5f3759df - ( i >> 1 ); 
// y  = * ( float * ) &i;
bb.putInt(0, i);
float y = bb.getFloat(0);