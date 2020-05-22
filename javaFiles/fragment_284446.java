int subnet = 0x0A010100;   // 10.1.1.0/24
int bits   = 24;
int ip     = 0x0A010199;   // 10.1.1.99

// Create bitmask to clear out irrelevant bits. For 10.1.1.0/24 this is
// 0xFFFFFF00 -- the first 24 bits are 1's, the last 8 are 0's.
//
//     -1        == 0xFFFFFFFF
//     32 - bits == 8
//     -1 << 8   == 0xFFFFFF00
mask = -1 << (32 - bits)

if ((subnet & mask) == (ip & mask)) {
    // IP address is in the subnet.
}