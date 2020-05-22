unsigned char data[8] = {/* put data here */};

// chop off the top bit of the first byte
data[0] <<= 1;

// the bottom bit of data[0] needs to come from the top data bit of data[1]
data[0] |= (data[1] >> 6) & 0x01;

// use similar transformations to fill in data[1], data[2], ... data[6]
// At the end, data[7] will be useless