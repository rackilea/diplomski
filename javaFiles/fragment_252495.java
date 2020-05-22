int64 r, t, z;
r = start[(x >> 3) & 1023];
do {
    z = x - r * r;
    if( z == 0 )
        return true;
    if( z < 0 )
        return false;
    t = z & (-z);
    r += (z & t) >> 1;
    if( r > (t >> 1) )
        r = t - r;
} while( t <= (1LL << 33) );