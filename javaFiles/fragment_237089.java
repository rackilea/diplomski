public static byte[] variableLengthInteger(int input) {
    // first find out how many bytes we need to represent the integer
    int numBytes = ((32 - Integer.numberOfLeadingZeros(input)) + 6) / 7;
    // if the integer is 0, we still need 1 byte
    numBytes = numBytes > 0 ? numBytes : 1;
    byte[] output = new byte[numBytes];
    // for each byte of output ...
    for(int i = 0; i < numBytes; i++) {
        // ... take the least significant 7 bits of input and set the MSB to 1 ...
        output[i] = (byte) ((input & 0b1111111) | 0b10000000);
        // ... shift the input right by 7 places, discarding the 7 bits we just used
        input >>= 7;
    }
    // finally reset the MSB on the last byte
    output[0] &= 0b01111111; 
    return output;
}