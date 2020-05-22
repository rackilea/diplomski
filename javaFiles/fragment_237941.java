uint8_t output[5];
output[0] = sample;
output[1] = (uint8_t)(command >>  0);
output[2] = (uint8_t)(command >>  8);
output[3] = (uint8_t)(command >> 16);
output[4] = (uint8_t)(command >> 32);