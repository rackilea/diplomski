// y  = number;
float y = number;
// i  = * ( long * ) &y;
int i = Float.floatToRawIntBits(f);
// i  = 0x5f3759df - ( i >> 1 );
i  = 0x5f3759df - ( i >> 1 ); 
// y  = * ( float * ) &i;
y = Float.intBitsToFloat(i);