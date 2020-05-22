int bits = 0;

// Set bit n
bits |= 1 << n;

// Clear bit n
bits &= (1 << n) ^ -1;

// Check bit n
if ((bits & 1 << n) != 0) { /*bit was set*/ }